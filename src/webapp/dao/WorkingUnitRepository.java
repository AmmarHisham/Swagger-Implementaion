package webapp.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import webapp.domain.WorkingRating;
import webapp.domain.WorkingUnit;

@Repository
public interface WorkingUnitRepository extends JpaRepository<WorkingUnit,Serializable>,JpaSpecificationExecutor{
	
}