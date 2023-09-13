package com.visitormgmt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitormgmt.entity.Visitor;
import com.visitormgmt.services.impl.VisitorServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	public VisitorServiceImpl visitorServiceimpl;

	// Create Visitor Data By SchoolId (d)

	@PostMapping("/visitors/{schoolId}")
	public ResponseEntity<Visitor> createVisitor(@Valid @RequestBody Visitor visitor, @PathVariable Long schoolId) {
		Visitor createVisitorDto = this.visitorServiceimpl.createVisitor(visitor, schoolId);
		return new ResponseEntity<>(createVisitorDto, HttpStatus.CREATED);

	}

	// Update Visitors By visitorId with SchoolId(d)

	@PutMapping("/visitors/{schoolId}/{visitorId}")
	public ResponseEntity<Visitor> udateVisitor(@Valid @RequestBody Visitor visitor, @PathVariable Long schoolId,
			@PathVariable Long visitorId) {

		Visitor updatedVisitor = this.visitorServiceimpl.updateVisitor(visitor, visitorId, schoolId);
		return ResponseEntity.ok(updatedVisitor);

	}

	// Search By SchoolId And Mobile (d)

	@GetMapping("/visitors/mobileschoolId")
	public List<Visitor> searchVisitorsByMobile(@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("schoolId") Long schoolId) {
		return visitorServiceimpl.findByMobileNumberAndSchoolId(mobileNumber, schoolId);
	}

	// Search By SchoolId And Date (d)

	@GetMapping("/visitors/dateschoolId")
	public List<Visitor> searchVisitors(@RequestParam("date") String date, @RequestParam("schoolId") Long schoolId) {

		return visitorServiceimpl.findByDateAndSchoolId(date, schoolId);
	}

	// get Visitor By visitorId with schoolId(d)
	@GetMapping("/visitors/{schoolId}/{visitorId}")
	public ResponseEntity<Visitor> getVisitorswithSchoolId(@PathVariable Long schoolId, @PathVariable Long visitorId) {
		Visitor v = this.visitorServiceimpl.getVisitorsByVisitorIdAndSchoolId(visitorId, schoolId);
		return ResponseEntity.ok(v);
	}

	// Get Visitors By SchoolId with pagination(d)
	@GetMapping("visitors/{schoolId}")
	public Page<Visitor> getVisitorsBySchoolId(@PathVariable Long schoolId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		return visitorServiceimpl.getVisitorsBySchoolId(schoolId, pageRequest);
	}
}
