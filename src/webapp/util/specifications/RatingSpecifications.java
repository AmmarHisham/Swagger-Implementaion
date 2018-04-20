package webapp.util.specifications;

import java.awt.event.AdjustmentEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import webapp.domain.LastApprovedPlan;
import webapp.domain.LastApprovedUnit;
import webapp.domain.Plan;
import webapp.domain.WorkingPlan;
import webapp.domain.WorkingRating;
import webapp.domain.WorkingUnit;
import webapp.domain.request.RatingRequestParam;

@RefreshScope
public class RatingSpecifications {
	
	@Value("${ratingtables.working}")
	private String workingRatingTable;

	@Value("${ratingtables.lastapproved}")
	private String lastApprovedRatingTable;

	@Value("${ratingtables.allratings}")
	private String allratings;


	public static Specification<WorkingRating> hasChannelIdsIn(List<Long> channelIds) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("propertyId").in(channelIds));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> hasChannelNamesIn(List<String> channelNames) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("propertyName").in(channelNames));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> hasPlansIn(List<Long> plans) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("planId").in(plans));
				return query.getRestriction();
			}
			
		};
	}

	public static Specification<WorkingRating> hasExtUsns(List<Long> extUsns) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("externalUsn").in(extUsns));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> hasTargetGrpIdsIn(List<Long> targetGrpIds) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("targetGroupId").in(targetGrpIds));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> hasTargetGrpNamesIn(List<String> targetGrpNames) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("targetGroupName").in(targetGrpNames));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> hasStewStatusIn(List<String> stewStatus) {
		return new Specification<WorkingRating>() {

			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("stewardshipStatus").in(stewStatus));
				return query.getRestriction();
			}
		};
	}

	public static Specification<WorkingRating> dummyCondition() {
		return new Specification<WorkingRating>() {
			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(root.get("planId").isNotNull());
				return query.getRestriction();
			}
		};
	}
	
	public static Specification<WorkingRating> existsPlanCondition(RatingRequestParam exportParams) {
		return new Specification<WorkingRating>() {
			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Subquery sq=null;
					Root sqRoot=null;
					if(exportParams.getRatingTable().equalsIgnoreCase("working")){
						sq = query.subquery(WorkingPlan.class);
						sqRoot = sq.from(WorkingPlan.class);
					}else {
						sq = query.subquery(LastApprovedPlan.class);
			            sqRoot = sq.from(LastApprovedPlan.class);
					}
		            Predicate join=cb.equal(sqRoot.get("planId"), root.get("planId"));
		            Predicate planIdList=cb.in(sqRoot.get("planId")).value(exportParams.getPlans());
		            Predicate propertyIdList=cb.in(sqRoot.get("propertyId")).value(exportParams.getChannels());
		            Predicate propertyNamesList=cb.in(sqRoot.get("propertyName")).value(exportParams.getChannelNames());
		            Predicate planClassList=cb.in(sqRoot.get("planClass")).value(exportParams.getPlanClasses());
		            Predicate startClause=cb.lessThanOrEqualTo(sqRoot.get("startDate"), exportParams.getPlanEndDate());
		            Predicate EndClause=cb.greaterThanOrEqualTo(sqRoot.get("endDate"), exportParams.getPlanStartDate());
		            Predicate planSubStatList=cb.in(sqRoot.get("planSubStatus")).value(exportParams.getPlanSubStatus());
		            Predicate agencyIdList=cb.in(sqRoot.get("agencyId")).value(exportParams.getAgencies());
		            Predicate agencyNamesList=cb.in(sqRoot.get("agencyName")).value(exportParams.getAgencyNames());
		            Predicate advertiserIdList=cb.in(sqRoot.get("advertiserId")).value(exportParams.getAdvertisers());
		            Predicate advertiserNamesList=cb.in(sqRoot.get("advertiserName")).value(exportParams.getAdvertiserNames());
		            Predicate aeIdList=cb.in(sqRoot.get("aeId")).value(exportParams.getAccountExecs());            
		            Predicate aeNamesList=cb.in(sqRoot.get("aeName")).value(exportParams.getAccountExecNames());
		            Predicate orgPlanIdList=cb.in(sqRoot.get("originalPlanId")).value(exportParams.getOriginalPlans());
		            Predicate qtrStart=cb.equal(sqRoot.get("qtrStart"), exportParams.getQtrStartDate());
		            Predicate qtrEnd=cb.equal(sqRoot.get("qtrEnd"), exportParams.getQtrEndDate());
		            Predicate divIdList=cb.in(sqRoot.get("divisionId")).value(exportParams.getDivisions());
		            Predicate subDivIdList=cb.in(sqRoot.get("subDivisionId")).value(exportParams.getSubDivisions());
		            Predicate planStatusList=cb.in(sqRoot.get("planStatusCode")).value(exportParams.getPlanStatus());
		            Predicate planAppStatusDescList=cb.in(sqRoot.get("approvalStatusDesc")).value(exportParams.getApprovalStatusDesc());
		            Predicate guaranteedList=cb.in(sqRoot.get("guaranteed")).value(exportParams.getGuaranteed());
		            //Predicate modifiedDate=cb.between(sqRoot.get("guaranteed"), exportParams.getPlanModificationDateFrom(), exportParams.getPlanModificationDateTo());
		            
		            List<Predicate> predList=new ArrayList<Predicate>();
		            predList.add(join);
		            if(exportParams.getPlans()!=null&&exportParams.getPlans().size()>0)
		            	predList.add(planIdList);
		            if(exportParams.getChannels()!=null&&exportParams.getChannels().size()>0)
		            	predList.add(propertyIdList);
		           
		            if(exportParams.getChannelNames()!=null&&exportParams.getChannelNames().size()>0)
		            	predList.add(propertyNamesList);
		            if(exportParams.getPlanClasses()!=null&&exportParams.getPlanClasses().size()>0)
		            	predList.add(planClassList);
		            
		            if(exportParams.getPlanStartDate()!=null&&!exportParams.getPlanStartDate().isEmpty())
		            	predList.add(startClause);
		            if(exportParams.getPlanEndDate()!=null&&!exportParams.getPlanEndDate().isEmpty())
		            	predList.add(EndClause);
		            
		            
		            if(exportParams.getPlanSubStatus()!=null&&exportParams.getPlanSubStatus().size()>0)
		            	predList.add(planSubStatList);
		            

		            if(exportParams.getAgencies()!=null&&exportParams.getAgencies().size()>0)
		            	predList.add(agencyIdList);
		            
		            
		            if(exportParams.getAgencyNames()!=null&&exportParams.getAgencyNames().size()>0)
		            	predList.add(agencyNamesList);
		            
		            
		            
		            if(exportParams.getAdvertisers()!=null&&exportParams.getAdvertisers().size()>0)
		            	predList.add(advertiserIdList);
		            
		            if(exportParams.getAdvertiserNames()!=null&&exportParams.getAdvertiserNames().size()>0)
		            	predList.add(advertiserNamesList);
		            
		            
		            if(exportParams.getOriginalPlans()!=null&&exportParams.getOriginalPlans().size()>0)
		            	predList.add(orgPlanIdList);
		            
		            
		            if(exportParams.getQtrStartDate()!=null&&!exportParams.getQtrStartDate().isEmpty())
		            	predList.add(qtrStart);
		            
		            if(exportParams.getQtrEndDate()!=null&&!exportParams.getQtrEndDate().isEmpty())
		            	predList.add(qtrEnd);
		            
		            
		            if(exportParams.getDivisions()!=null&&exportParams.getDivisions().size()>0)
		            	predList.add(divIdList);
		            
		            
		            if(exportParams.getSubDivisions()!=null&&exportParams.getSubDivisions().size()>0)
		            	predList.add(subDivIdList);
		            
		            
		            if(exportParams.getApprovalStatusDesc()!=null&&exportParams.getApprovalStatusDesc().size()>0)
		            	predList.add(planAppStatusDescList);
		            
		            
		            if(exportParams.getGuaranteed()!=null&&exportParams.getGuaranteed().size()>0)
		            	predList.add(guaranteedList);
		            
		            if(exportParams.getPlanModificationDateFrom()!=null&&!exportParams.getPlanModificationDateFrom().isEmpty()&&exportParams.getPlanModificationDateTo()!=null&&!exportParams.getPlanModificationDateTo().isEmpty()){
		            	SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		            	java.util.Date fromDate=null;
		            	java.util.Date toDate=null;
		        		try {
							fromDate=format.parse(exportParams.getPlanModificationDateFrom());
							toDate=format.parse(exportParams.getPlanModificationDateTo());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	Predicate modifiedDateGTE=cb.greaterThanOrEqualTo(sqRoot.get("modificationDate"), fromDate);
		            	Predicate modifiedDateLTE=cb.lessThanOrEqualTo(sqRoot.get("modificationDate"), toDate);
		            	predList.add(modifiedDateGTE);
		            	predList.add(modifiedDateLTE);
		            }
		            Predicate [] predArr = new Predicate[predList.size()];
		            predList.toArray(predArr);
				return cb.exists(sq.select(sqRoot).where(predArr));
			}
		};
	}
	
	
	public static Specification<WorkingRating> existsUnitCondition(RatingRequestParam exportParams) {
		return new Specification<WorkingRating>() {
			@Override
			public Predicate toPredicate(Root<WorkingRating> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Subquery sq=null;
					Root sqRoot=null;
					List<Predicate> predList=new ArrayList<Predicate>();
					if(exportParams.getRatingTable().equalsIgnoreCase("working")){
						sq = query.subquery(WorkingUnit.class);
						sqRoot = sq.from(WorkingUnit.class);
					}else {
						sq = query.subquery(LastApprovedUnit.class);
			            sqRoot = sq.from(LastApprovedUnit.class);
					}
		            Predicate join=cb.equal(sqRoot.get("planId"), root.get("planId"));
		            Predicate joinExtnUsn=cb.equal(sqRoot.get("externalUsn"), root.get("externalUsn"));
		            Predicate externalUsnList=cb.in(sqRoot.get("externalUsn")).value(exportParams.getExternalUsns());
		            
		            Predicate spotPlanStatusList=cb.in(sqRoot.get("spotPlanStatus")).value(exportParams.getSpotPlanStatus());
		            Predicate logTypeList=cb.in(sqRoot.get("logType")).value(exportParams.getLogType());
		            Predicate salesUnitIdList=cb.in(sqRoot.get("salesUnitId")).value(exportParams.getSalesUnitIds());
		            Predicate unitDurationList=cb.in(sqRoot.get("unitDuration")).value(exportParams.getUnitDurations());
		            Predicate spotQtrList=cb.in(sqRoot.get("spotQtr")).value(exportParams.getQuarters());
		            
		            predList.add(join);
		            predList.add(joinExtnUsn);
		            
		            if(exportParams.getExternalUsns()!=null&&exportParams.getExternalUsns().size()>0)
		            	predList.add(externalUsnList);
		            
		            if(exportParams.getUnitEndDate()!=null&&!exportParams.getUnitEndDate().isEmpty()&&exportParams.getUnitStartDate()!=null&&!exportParams.getUnitStartDate().isEmpty()){
		            	Predicate spotDateClause=cb.between(sqRoot.get("spotDate"), exportParams.getUnitStartDate(), exportParams.getUnitEndDate());
		            	 predList.add(spotDateClause);
		            }
		            
		            if(exportParams.getSpotPlanStatus()!=null&&exportParams.getSpotPlanStatus().size()>0)
		            	predList.add(spotPlanStatusList);
		            
		            if(exportParams.getLogType()!=null&&exportParams.getLogType().size()>0)
		            	predList.add(logTypeList);
		            
		            if(exportParams.getSalesUnitIds()!=null&&exportParams.getSalesUnitIds().size()>0)
		            	predList.add(salesUnitIdList);
		            
		            if(exportParams.getUnitDurations()!=null&&exportParams.getUnitDurations().size()>0)
		            	predList.add(unitDurationList);
		            
		            if(exportParams.getQuarters()!=null&&exportParams.getQuarters().size()>0)
		            	predList.add(spotQtrList);
		            
		            Predicate [] predArr = new Predicate[predList.size()];
		            predList.toArray(predArr);
				return cb.exists(sq.select(sqRoot).where(predArr));
			}
		};
}
}