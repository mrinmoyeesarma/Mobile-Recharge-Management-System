package com.recharge.admin.controller;

import java.util.List;

import com.recharge.admin.entity.Subscription;
import com.recharge.admin.payload.RechargePlanDto;
import com.recharge.admin.payload.SubscribedPlansDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.service.RechargePlanService;

@RestController
@RequestMapping("api/posts")
public class AdminController {
	@Autowired
	private RechargePlanService rechargePlanService;

//	public AdminController(RechargePlanService rechargePlanService) {
//		this.rechargePlanService = rechargePlanService;
//	}

	// get all the plans
	@GetMapping
	public ResponseEntity<List<RechargePlan>> getAllPlans() {
		List<RechargePlan> rlist = rechargePlanService.fetchPlans();
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}

	// Add all the rechargePlans for the rest API
	@PostMapping
	public ResponseEntity<RechargePlan> createPost(@RequestBody RechargePlan rechargePlan) {
		return new ResponseEntity<>(rechargePlanService.createPost(rechargePlan), HttpStatus.CREATED);
	}

	// update post by id using rest api
	@PutMapping("/{id}")
	public ResponseEntity<RechargePlan> updatePost(@RequestBody RechargePlan rechargePlan,
			@PathVariable(name = "id") long id) {
		RechargePlan rechargeResponse = rechargePlanService.updatePost(rechargePlan, id);
			return new ResponseEntity<>(rechargeResponse,HttpStatus.OK); 
	}

	// delete post by id using rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
		rechargePlanService.deleteRechargePlanById(id);
		return new ResponseEntity<>("Recharge deleted succesfully", HttpStatus.OK);
	}

	// View Subscribed Plans
	@GetMapping("/view-subscribed-plans/{username}")
	public ResponseEntity<List<SubscribedPlansDto>> viewSubscribedPlans(@PathVariable(name = "username") String username) {
		List<SubscribedPlansDto> response = rechargePlanService.getSubscribedPlans(username);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
