package com.gym.entity;

import java.util.Objects;

public class SaleSubscription extends BaseEntity {

    private String startDate;

    private String endDate;

    private Integer clientId;

    private Integer subscriptionId;

    public SaleSubscription(String startDate, String endDate, Integer clientId,
                            Integer subscriptionId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.subscriptionId = subscriptionId;
    }

    public SaleSubscription(){}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleSubscription that = (SaleSubscription) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(subscriptionId, that.subscriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, clientId, subscriptionId);
    }

    @Override
    public String toString() {
        return "SaleSubscription{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", clientId=" + clientId +
                ", subscriptionId=" + subscriptionId +
                '}';
    }
}
