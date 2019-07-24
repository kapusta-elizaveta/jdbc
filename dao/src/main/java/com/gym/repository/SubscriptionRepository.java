package com.gym.repository;

import com.gym.entity.Subscription;

import java.util.List;

public interface SubscriptionRepository {

    void save(Subscription subscription);

    List<Subscription> findAll();

    List<Subscription> findCheaperSubscription(double price);

    Subscription findById(Integer id);

    void deleteById(Integer id);
}
