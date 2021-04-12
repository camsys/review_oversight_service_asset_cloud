package com.camsys.assetcloud.oversight.model;

import java.util.List;
import java.util.stream.Collectors;

import com.camsys.assetcloud.model.BaseDatabaseDAO;

import jakarta.ws.rs.core.SecurityContext;

public class DatabaseDAO extends BaseDatabaseDAO {
	
	public DatabaseDAO(SecurityContext sc) {
		super(sc);
	}

	public List<Review> getAllTemplates() {
		if(dbSession == null) { 
			dbSession = sessionFactory.openSession();
			dbSession.beginTransaction();
		}
		
		List<Review> a = dbSession.createQuery("from Template", Review.class).list()
				.stream()
				.filter(it -> readableOrganizationIds.contains(it.reviewee.id))
				.collect(Collectors.toList());
		
		return a;
	}
	
	public void saveTemplate(Review a) throws Exception {
		if(a.reviewer == null)
			a.reviewer = getCurrentOrganization();
		
		if(!writableOrganizationIds.contains(a.reviewee.id))
			throw new Exception("Access to this review organization is not allowed");		
		
		if(dbSession == null) { 
			dbSession = sessionFactory.openSession();
			dbSession.beginTransaction();
		}

		dbSession.save(a);		
		dbSession.getTransaction().commit();
		dbSession.beginTransaction(); // open one for next time
	}
}
