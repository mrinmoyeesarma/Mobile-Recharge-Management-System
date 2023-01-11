package com.recharge.admin.payload;

import com.recharge.admin.entity.RechargePlan;

public class SubscribedPlanDto {
	private RechargePlan rechargePlan;
	private int totalNoOfRecharges;

	public RechargePlan getRechargePlan() {
		return rechargePlan;
	}

	public void setRechargePlan(RechargePlan rechargePlan) {
		this.rechargePlan = rechargePlan;
	}

	public int getTotalNoOfRecharges() {
		return totalNoOfRecharges;
	}

	public void setTotalNoOfRecharges(int totalNoOfRecharges) {
		this.totalNoOfRecharges = totalNoOfRecharges;
	}

}
