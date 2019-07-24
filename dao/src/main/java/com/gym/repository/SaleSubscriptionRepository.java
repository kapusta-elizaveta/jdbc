package com.gym.repository;

import com.gym.entity.SaleSubscription;

import java.util.List;

public interface SaleSubscriptionRepository {

    void save(SaleSubscription saleSubscription);

    List<com.gym.entity.SaleSubscription> findByClientId(Integer id);

    List<com.gym.entity.SaleSubscription> findBySubscriptionId(Integer id);

    void deleteById(Integer id);

    SaleSubscription findById(Integer id);
}
