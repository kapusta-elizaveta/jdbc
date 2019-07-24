package com.gym.service.impl;

import com.gym.convertors.SubscriptionConvert;
import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import com.gym.myException.SubscriptionNotFoundException;
import com.gym.repository.SubscriptionRepository;
import com.gym.service.ClientService;
import com.gym.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final ClientService clientService;

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionConvert subscriptionConvert;

    @Autowired
    public SubscriptionServiceImpl(ClientService clientService, SubscriptionRepository subscriptionRepository,
                                   SubscriptionConvert subscriptionConvert) {
        this.clientService = clientService;
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionConvert = subscriptionConvert;
    }


    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public List<Subscription> findCheaperSubscription(double price) {
       if (price <=0) throw new IllegalArgumentException("Price is less than 1");
        return subscriptionRepository.findCheaperSubscription(price);
    }

    @Override
    public Subscription findById(Integer id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public void save(SubscriptionDto subscriptionDto) {
        Subscription subscription = subscriptionConvert.convert(subscriptionDto);
        subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        subscriptionRepository.deleteById(id);
    }
}
