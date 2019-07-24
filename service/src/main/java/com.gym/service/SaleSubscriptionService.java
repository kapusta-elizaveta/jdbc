package com.gym.service;

import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;

import java.util.List;

public interface SaleSubscriptionService {

    List<SaleSubscription> findByClientId(Integer id);

    List<SaleSubscription> findBySubscriptionId(Integer id);

    void save(SaleSubscriptionDto saleSubscriptionDto);

    void deleteById(Integer id);

    SaleSubscription findById(Integer id);
}
