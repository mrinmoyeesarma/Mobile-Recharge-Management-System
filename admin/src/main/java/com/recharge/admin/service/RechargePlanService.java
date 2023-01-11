package com.recharge.admin.service;

import java.util.List;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.entity.Subscription;
import com.recharge.admin.payload.RechargePlanDto;
import com.recharge.admin.payload.SubscribedPlansDto;

public interface RechargePlanService {
	List<RechargePlan> fetchPlans();

	RechargePlan createPost(RechargePlan rechargePlan);

	RechargePlan updatePost(RechargePlan rechargePlan, long id);

	void deleteRechargePlanById(long id);

	List<SubscribedPlansDto> getSubscribedPlans(String username);

}
