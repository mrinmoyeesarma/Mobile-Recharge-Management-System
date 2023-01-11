package com.recharge.admin.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.recharge.admin.entity.Subscription;
import com.recharge.admin.payload.SubscribedPlansDto;
import com.recharge.admin.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.exception.ResourceNotFoundException;
import com.recharge.admin.payload.RechargePlanDto;
import com.recharge.admin.repository.RechargePlanRepository;
import com.recharge.admin.service.RechargePlanService;


@Service
public class RechargePlanServiceImpl implements RechargePlanService {
	@Autowired
	private RechargePlanRepository rechargePlanRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired

//	public RechargePlanServiceImpl(RechargePlanRepository rechargePlanRepository, SubscriptionRepository subscriptionRepository) {
//		this.rechargePlanRepository = rechargePlanRepository;
//		this.subscriptionRepository = subscriptionRepository;
//	}

	@Override
	// To fetch all the plans
	public List<RechargePlan> fetchPlans() {
		List<RechargePlan> list = rechargePlanRepository.findAll();
		return list;
	}

	// to add new plans
	public RechargePlan createPost(RechargePlan rechargePlan) {
		RechargePlan newRechargePlan = rechargePlanRepository.save(rechargePlan);
		return newRechargePlan;
	}

	// To update and get recharge id from database
	public RechargePlan updatePost(RechargePlan rechargePlanDto, long id) {
		RechargePlan planupdate = rechargePlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RechargePlan", "id", id));
		planupdate.setPlan_id(rechargePlanDto.getPlan_id());
		planupdate.setPlanName(rechargePlanDto.getPlanName());
		planupdate.setNetworkProvider(rechargePlanDto.getNetworkProvider());
		planupdate.setAmount(rechargePlanDto.getAmount());
		planupdate.setValidity(rechargePlanDto.getValidity());
		planupdate.setAvailable(rechargePlanDto.isAvailable());

		RechargePlan updatedPost = rechargePlanRepository.save(planupdate);

		return updatedPost;

	}
	// get deleted rechargeid
	public void deleteRechargePlanById(long id) {
	
		RechargePlan rechargePlan = rechargePlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RechargePlan", "id", id));
		rechargePlanRepository.delete(rechargePlan);
	}

	// Get Subscribed Plans
	@Override
	public List<SubscribedPlansDto> getSubscribedPlans(String username) {
		List<Subscription> subscriptions = subscriptionRepository.findByUsername(username);
		List<String> networkProviders = subscriptions.stream().map(subscription -> subscription.getNetworkProvider()).collect(Collectors.toList());
		Set<String> distinctNetworkProviders = new HashSet<String>(networkProviders);
		List<SubscribedPlansDto> subscribedPlansDtos = new ArrayList<>();
		for (String provider: distinctNetworkProviders) {
			subscribedPlansDtos.add(new SubscribedPlansDto(provider, Collections.frequency(networkProviders, provider)));
		}
		return subscribedPlansDtos;
	}

}
