package webapp.wrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.domain.parameter.AbstractExportParam;
import webapp.domain.response.DataMakerJobStatus;
import webapp.domain.response.DataMakerResponseObject;

@Component
@ConfigurationProperties()
@RefreshScope
public abstract class AbstractDatamakerWrapper {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${datamaker.createDataURI}")
	private String createDataURI;

	@Value("${datamaker.statusURI}")
	private String statusURI;

	static BlockingQueue<String> pollingQueue = new LinkedBlockingQueue<String>();

	RestTemplate restTemplate = new RestTemplate();

	ObjectMapper mapperObj = new ObjectMapper();

	public List<String> procInvoker(List<? extends AbstractExportParam> datamakerInput) {

		HttpHeaders headers = new HttpHeaders();
		List<String> responseList = null;
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<List<? extends AbstractExportParam>> entity = new HttpEntity<List<? extends AbstractExportParam>>(
				datamakerInput, headers);
		log.debug("Request with Header : " + entity);
		String response = restTemplate.postForObject(createDataURI, entity, String.class);
		try {
			responseList = mapperObj.readValue(response,
					mapperObj.getTypeFactory().constructCollectionType(List.class, String.class));
			log.debug("Datamaker Response : " + responseList);
			System.out.println("Datamaker Response : " + responseList);
			String requestJson = mapperObj.writeValueAsString(entity);
			log.debug("requestJson : " + requestJson);
		} catch (JsonParseException e) {
			log.error("Exception while JSON parsing", e.toString());
		} catch (JsonMappingException e) {
			log.error("Exception while JSON mapping", e.toString());
		} catch (IOException e) {
			log.error("IOException ", e.toString());
		}
		return responseList;

	};

	public Map<String, List<DataMakerJobStatus>> checkStatus(List<String> uuids) {
		List<DataMakerResponseObject> statusResponseList = null;
		// String status="active";
		Map<String, List<DataMakerJobStatus>> allRanJobs = new HashMap<String, List<DataMakerJobStatus>>();
		List<DataMakerJobStatus> completedJobs = new ArrayList<DataMakerJobStatus>();
		List<DataMakerJobStatus> failedJobs = new ArrayList<DataMakerJobStatus>();

		
		statusResponseList = getStatusResponseFromDM(statusURI + uuids.get(0), DataMakerResponseObject.class);
		
		// all jobs are completed now. check for errors

		for (DataMakerJobStatus statusResponse : statusResponseList.get(0).getJobStatuses()) {
			
			if (statusResponse.getJobStatus().toLowerCase().contains("complete")) 
				completedJobs.add(statusResponse);
			else
				failedJobs.add(statusResponse);
		}
		allRanJobs.put("completedJobs", completedJobs);
		allRanJobs.put("failedJobs", failedJobs);
		log.debug("Failed Jobs : "+failedJobs.size());
		log.debug("Completed Jobs : "+completedJobs.size());
		return allRanJobs;
	}

	public List<DataMakerResponseObject> getStatusResponseFromDM(String uri, Class responseType) {
		List<DataMakerResponseObject> statusResponseList = new ArrayList<DataMakerResponseObject>();
		try {	
			Thread.sleep(2000);
			statusResponseList =  mapperObj.readValue(restTemplate.getForObject(uri,String.class),
						mapperObj.getTypeFactory().constructCollectionType(List.class, DataMakerResponseObject.class));
			if (statusResponseList.get(0)!=null && statusResponseList.get(0).getPayloadStatus()!=null && !statusResponseList.get(0).getPayloadStatus().equalsIgnoreCase("complete")) {					
				statusResponseList = getStatusResponseFromDM(uri, responseType);
			}
		} catch (Exception e) {
			log.debug("Exception in getStatusResponseFromDM::" + e);
		}
		return statusResponseList;
	}

}
