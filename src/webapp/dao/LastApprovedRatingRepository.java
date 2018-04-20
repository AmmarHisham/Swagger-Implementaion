package webapp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import webapp.domain.LastApprovedRating;

@Repository
public interface LastApprovedRatingRepository extends JpaRepository<LastApprovedRating,Serializable>,JpaSpecificationExecutor{
	
	}