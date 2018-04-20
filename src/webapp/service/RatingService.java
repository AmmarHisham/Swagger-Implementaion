package webapp.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import webapp.dao.LastApprovedRatingRepository;
import webapp.dao.WorkingRatingRepository;
import webapp.domain.Rating;
import webapp.domain.RatingPK;
import webapp.domain.request.RatingRequestParam;
import webapp.util.specifications.RatingSpecifications;

@Service
@RefreshScope
public class RatingService extends AbstractService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * @Autowired private SalesUnitDatamakerWrapper datamakerWrapper;
	 * 
	 * @Autowired private SalesUnitDataProcessor dataProcessor;
	 */

	@Autowired
	WorkingRatingRepository workingRatingRepo;

	@Autowired
	LastApprovedRatingRepository lastApprovedRatingRepo;

	@Value("${ratingtables.working}")
	private String workingRatingTable;

	@Value("${ratingtables.lastapproved}")
	private String lastApprovedRatingTable;

	@Value("${data.page.defaultSize}")
	private int PAGE_SIZE;
	
	@Value("${data.page.maxSize}")
	private int MAX_PAGE_SIZE;
	/*
	@Value("${data.page.sortParam}")
	private String sortParam;*/
	
	public List<Rating> getRatingData(RatingRequestParam exportParam) throws Exception {
		List<Rating> ratingData = new ArrayList<Rating>();
		Specifications superSpec = null;
		Specifications planSpec = null;
		Specifications extUsnSpec = null;
		List<List<Long>> masterList = null;
		try {
			
			superSpec = buildSpec(exportParam);
			/*
			 * if (exportParam.getExtUsns() != null &&
			 * exportParam.getExtUsns().size() > 0) { masterList =
			 * splitByThousand(exportParam.getExtUsns()); extUsnSpec =
			 * Specifications.where(RatingSpecifications.hasExtUsns((masterList.
			 * get(0)))); masterList.remove(0); for (List<Long> usnList :
			 * masterList) { extUsnSpec =
			 * extUsnSpec.or(RatingSpecifications.hasExtUsns(((usnList)))); }
			 * superSpec = superSpec.and(extUsnSpec); }
			 */

			// Added to incrementally pass usns to the db
			if (exportParam.getExternalUsns() != null && exportParam.getExternalUsns().size() > 0) {
				masterList = splitByThousand(exportParam.getExternalUsns());
				for (List<Long> usnList : masterList) {
					extUsnSpec = Specifications.where(RatingSpecifications.hasExtUsns((usnList)));
					if (exportParam.getRatingTable().equalsIgnoreCase(workingRatingTable))							
						ratingData = (workingRatingRepo.findAll(superSpec.and(extUsnSpec)));
					if (exportParam.getRatingTable().equalsIgnoreCase(lastApprovedRatingTable))							
						ratingData = (lastApprovedRatingRepo.findAll(superSpec.and(extUsnSpec)));
				}
				// superSpec = superSpec.and(extUsnSpec);
			} else {
				if (exportParam.getRatingTable().equalsIgnoreCase(workingRatingTable))						
					ratingData = workingRatingRepo.findAll(superSpec);
				if (exportParam.getRatingTable().equalsIgnoreCase(lastApprovedRatingTable))						
					ratingData = (lastApprovedRatingRepo.findAll(superSpec));
			}
		} catch (Exception e) {
			throw e;
		}
		return ratingData;
	}

	public Page<Rating> getRatingData(RatingRequestParam exportParam,Integer pageNumber,Integer pageSize) throws Exception {
		Page<Rating> ratingData = null;
		Specifications superSpec = null;
		Specifications planSpec = null;
		Specifications extUsnSpec = null;
		List<List<Long>> masterList = null;
		try {
			
			superSpec = buildSpec(exportParam);
			/*
			 * if (exportParam.getExtUsns() != null &&
			 * exportParam.getExtUsns().size() > 0) { masterList =
			 * splitByThousand(exportParam.getExtUsns()); extUsnSpec =
			 * Specifications.where(RatingSpecifications.hasExtUsns((masterList.
			 * get(0)))); masterList.remove(0); for (List<Long> usnList :
			 * masterList) { extUsnSpec =
			 * extUsnSpec.or(RatingSpecifications.hasExtUsns(((usnList)))); }
			 * superSpec = superSpec.and(extUsnSpec); }
			 */

			// Added to incrementally pass usns to the db
			PageRequest request =
		            new PageRequest(pageNumber - 1, !StringUtils.isEmpty(pageSize)&&pageSize>0?pageSize<=MAX_PAGE_SIZE?pageSize:MAX_PAGE_SIZE:PAGE_SIZE,Sort.DEFAULT_DIRECTION.DESC,getCompositeKeys(RatingPK.class));
			
			if (exportParam.getExternalUsns() != null && exportParam.getExternalUsns().size() > 0) {
				masterList = splitByThousand(exportParam.getExternalUsns());
				for (List<Long> usnList : masterList) {
					extUsnSpec = Specifications.where(RatingSpecifications.hasExtUsns((usnList)));
					if (exportParam.getRatingTable().equalsIgnoreCase(workingRatingTable))							
						ratingData = (workingRatingRepo.findAll(superSpec.and(extUsnSpec),request));
					if (exportParam.getRatingTable().equalsIgnoreCase(lastApprovedRatingTable))							
						ratingData = (lastApprovedRatingRepo.findAll(superSpec.and(extUsnSpec),request));
				}
				// superSpec = superSpec.and(extUsnSpec);
			} else {
				if (exportParam.getRatingTable().equalsIgnoreCase(workingRatingTable))						
					ratingData = workingRatingRepo.findAll(superSpec,request);
				if (exportParam.getRatingTable().equalsIgnoreCase(lastApprovedRatingTable))						
					ratingData = (lastApprovedRatingRepo.findAll(superSpec,request));
			}
		} catch (Exception e) {
			throw e;
		}
		return ratingData;
	}
	
	private String[] getCompositeKeys(Class clasz){
		
		Field[] compositeKeys=clasz.getDeclaredFields();
		String[] strCompKeys=new String[compositeKeys.length];
		for (int i=0;i<compositeKeys.length;i++) {
		 strCompKeys[i]=compositeKeys[i].getName();
		}
		return strCompKeys;
	}
	private Specifications buildSpec(RatingRequestParam exportParam){
		Specifications superSpec = null;
		try{
		superSpec = Specifications.where(RatingSpecifications.dummyCondition());
		superSpec = superSpec.and(RatingSpecifications.existsPlanCondition(exportParam));
		
		superSpec =superSpec.and(RatingSpecifications.existsUnitCondition(exportParam));
		
		/*
		 * planSpec =
		 * Specifications.where(RatingSpecifications.dummyCondition());
		 * extUsnSpec =
		 * Specifications.where(RatingSpecifications.dummyCondition());
		 */

		if (exportParam.getChannels() != null && exportParam.getChannels().size() > 0) {
			superSpec = superSpec.and(RatingSpecifications.hasChannelIdsIn((exportParam.getChannels())));
		}
		if (exportParam.getChannelNames() != null && exportParam.getChannelNames().size() > 0) {
			superSpec = superSpec.and(RatingSpecifications.hasChannelNamesIn((exportParam.getChannelNames())));
		}
		if (exportParam.getPlans() != null && exportParam.getPlans().size() > 0) {

			/*masterList = splitByThousand(exportParam.getPlans());
			planSpec = Specifications.where(RatingSpecifications.hasPlansIn((masterList.get(0))));
			masterList.remove(0);
			for (List<Long> planList : masterList) {
				planSpec = planSpec.or(RatingSpecifications.hasPlansIn((planList)));
			}
			superSpec = superSpec.and(planSpec);*/
			superSpec = superSpec.and(RatingSpecifications.hasPlansIn(exportParam.getPlans()));
		}

		if (exportParam.getTargetGrpIds() != null && exportParam.getTargetGrpIds().size() > 0) {
			superSpec = superSpec.and(RatingSpecifications.hasTargetGrpIdsIn((exportParam.getTargetGrpIds())));
		}
		if (exportParam.getTargetGrpNames() != null && exportParam.getTargetGrpNames().size() > 0) {
			superSpec = superSpec.and(RatingSpecifications.hasTargetGrpNamesIn((exportParam.getTargetGrpNames())));
		}
		if (exportParam.getStewardshipStatus() != null && exportParam.getStewardshipStatus().size() > 0) {
			superSpec = superSpec.and(RatingSpecifications.hasStewStatusIn((exportParam.getStewardshipStatus())));
		}
		}catch(Exception e){
			throw e;
		}
		
		return superSpec;
	}
	private List<List<Long>> splitByThousand(List<Long> objList) {
		List<List<Long>> masterList = new ArrayList<List<Long>>();
		int limit = 1000;
		if (objList.size() <= limit) {
			masterList.add(objList);
		} else {
			for (int i = 0; i < objList.size();) {
				if (i + limit > objList.size())
					masterList.add(objList.subList(i, objList.size()));
				else
					masterList.add(objList.subList(i, i + limit));
				i += limit;
			}
		}
		return masterList;
	}
}
