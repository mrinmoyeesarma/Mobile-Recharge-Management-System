package com.recharge.admin.payload;

import lombok.Data;

@Data
public class SubscribedPlansDto {
    String networkProvider;
    int numberOfSubscriptions;

    public SubscribedPlansDto() {
    }

    public SubscribedPlansDto(String networkProvider, int numberOfSubscriptions) {
        this.networkProvider = networkProvider;
        this.numberOfSubscriptions = numberOfSubscriptions;
    }

    public String getNetworkProvider() {
        return networkProvider;
    }

    public void setNetworkProvider(String networkProvider) {
        this.networkProvider = networkProvider;
    }

    public int getNumberOfSubscriptions() {
        return numberOfSubscriptions;
    }

    public void setNumberOfSubscriptions(int numberOfSubscriptions) {
        this.numberOfSubscriptions = numberOfSubscriptions;
    }
}
