package com.visitormgmt.repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.visitormgmt.entity.Visitor;

public interface VisitorRepo extends JpaRepository<Visitor, Long> {
	

	List<Visitor> findByMobileNumberAndSchoolId(String mobileNumber, Long schoolId);

	List<Visitor> findByDateAndSchoolId(String date, Long schoolId);

	Visitor findByVisitorIdAndSchoolId(Long visitorId, Long schoolId);

	Page<Visitor> findBySchoolId(Long schoolId, Pageable pageable);

}
