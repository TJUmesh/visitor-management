package com.visitormgmt.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.visitormgmt.entity.Visitor;
import com.visitormgmt.exceptions.ResourceNotFoundException;
import com.visitormgmt.repository.VisitorRepo;

@Service
public class VisitorServiceImpl {

	@Autowired
	public VisitorRepo visitorRepo;

	// Create Visitor By SchoolId
	public Visitor createVisitor(Visitor visitor, Long schoolId) {
		visitor.setSchoolId(schoolId);
		Visitor saveVisitor = this.visitorRepo.save(visitor);
		return saveVisitor;
	}

	// Update Visitor By visitorId with schoolId

	public Visitor updateVisitor(Visitor visitors, Long visitorId, Long schoolId) {
		Visitor visitor = this.visitorRepo.findByVisitorIdAndSchoolId(visitorId, schoolId);
		visitor.setVisitorName(visitors.getVisitorName());
		visitor.setMobileNumber(visitors.getMobileNumber());
		visitor.setAddress(visitors.getAddress());
		visitor.setClassId(visitors.getClassId());
		visitor.setStudentId(visitors.getStudentId());
		visitor.setRelationWith(visitors.getRelationWith());
		visitor.setReason(visitors.getReason());
		visitor.setPhoto(visitors.getPhoto());
		visitor.setTime(visitors.getTime());
		visitor.setDate(visitors.getDate());
		visitor.setAadharNumber(visitors.getAadharNumber());
		return visitorRepo.save(visitor);

	}

	// get by Id

//	public Visitor getVisitorById(Long visitorId) {
//		Visitor visitor = this.visitorRepo.findById(visitorId)
//				.orElseThrow(() -> new ResourceNotFoundException("Visitor", "Id", visitorId));
//		return visitor;
//	}

	// get All Visitor By SchoolId with Pagignation

	public Page<Visitor> getVisitorsBySchoolId(Long schoolId, Pageable pageable) {
		return visitorRepo.findBySchoolId(schoolId, pageable);
	}

	// get by MobileNumber and schoolId

	public List<Visitor> findByMobileNumberAndSchoolId(String mobileNumber, Long schoolId) {
		List<Visitor> visi = this.visitorRepo.findByMobileNumberAndSchoolId(mobileNumber, schoolId);

		return visi;
	}

	// Get Visitor By Date with schoolId
	public List<Visitor> findByDateAndSchoolId(String date, Long schoolId) {
		List<Visitor> visi = this.visitorRepo.findByDateAndSchoolId(date, schoolId);

		return visi;
	}

	// get Visitor By visitorId and SchoolId
	public Visitor getVisitorsByVisitorIdAndSchoolId(Long visitorId, Long schoolId) {
		return visitorRepo.findByVisitorIdAndSchoolId(visitorId, schoolId);
	}

}