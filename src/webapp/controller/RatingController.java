package webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import webapp.domain.Rating;
import webapp.domain.request.RatingRequestParam;
import webapp.domain.response.PageResponseObject;
import webapp.domain.response.ResponseObject;
import webapp.service.RatingService;;

@RestController
@RequestMapping(value = "/rating")
public class RatingController extends AbstractController {

	@Autowired
	private RatingService ratingService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/extractRatingData/{planType}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseObject> extractRatingData(@ApiParam(value="Specify list of filters to be applied to data",required=true)@RequestBody RatingRequestParam params,@ApiParam(value="Specify the type of plan data.",required=true,allowableValues="lastapproved,working",defaultValue="lastapproved")@PathVariable String planType ) {
		List<Rating> invExtract = null;
		ResponseObject resObj = new ResponseObject();
		params.setRatingTable(planType);
		try {
			invExtract = ratingService.getRatingData(params);
		if (invExtract != null) {
			resObj.setCount(invExtract.size());
			resObj.setData(invExtract);
			return new ResponseEntity<ResponseObject>(resObj, HttpStatus.OK);
		} else
			return new ResponseEntity<ResponseObject>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		resObj = new ResponseObject(e.getLocalizedMessage());
		return new ResponseEntity<ResponseObject>(HttpStatus.PRECONDITION_FAILED);
	}
}
	
	@RequestMapping(value="/extractRatingData/{planType}/page/{pageNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody	
	public ResponseEntity<PageResponseObject> extractPlanData(@ApiParam(value="Specify list of filters to be applied to data",required=true) @RequestBody RatingRequestParam params,
			@ApiParam(value="Specify page number",required=true,defaultValue="1") @PathVariable Integer pageNumber, @ApiParam(value="Specify page size",required=false,defaultValue="100") @RequestParam(required=false) Integer pageSize,@ApiParam(value="Specify the type of plan data.",required=true,allowableValues="lastapproved,working",defaultValue="lastapproved")@PathVariable String planType){
		Page<Rating> refData= null;
		PageResponseObject resObj = null;
		try{
			params.setRatingTable(planType);
			refData =  ratingService.getRatingData(params,pageNumber!=null&&pageNumber>0?pageNumber:1,pageSize);	
		if(refData!=null){
			resObj = new PageResponseObject(refData.getNumberOfElements(), refData.getContent(), refData.getTotalElements(), refData.getTotalPages(), refData.getSize(), refData.getNumber()+1);
			
			return new ResponseEntity<PageResponseObject>(resObj, HttpStatus.OK);
		}
		else
            return new ResponseEntity<PageResponseObject>(HttpStatus.NO_CONTENT);
		}catch(IllegalArgumentException ilae){
			resObj = new PageResponseObject(ilae.getMessage());
			return new ResponseEntity<PageResponseObject>(resObj, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resObj = new PageResponseObject(e.getMessage());
			return new ResponseEntity<PageResponseObject>(resObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
