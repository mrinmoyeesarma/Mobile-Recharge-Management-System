package com.recharge.admin.payload;

import lombok.Data;

@Data

public class RechargePlanDto {
	private long plan_id;
	private String networkProvider;
	private double amount;
	private String planName;
	private int validity;
	private boolean isAvailable;

	public long getPlan_id() {
		return plan_id;
	}

	public String getNetworkProvider() {
		return networkProvider;
	}

	public double getAmount() {
		return amount;
	}

	public String getPlanName() {
		return planName;
	}

	public int getValidity() {
		return validity;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

}
