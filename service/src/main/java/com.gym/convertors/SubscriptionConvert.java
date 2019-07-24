package com.gym.convertors;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionConvert {

    public SubscriptionDto convert(Subscription subscription){
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setNumberVisits(subscription.getNumberVisit());
        subscriptionDto.setPrice(subscription.getPrice());
        return subscriptionDto;
    }

    public Subscription convert(SubscriptionDto subscriptionDto){
        Subscription subscription = new Subscription();
        subscription.setId(subscriptionDto.getId());
        subscription.setNumberVisit(subscriptionDto.getNumberVisits());
        subscription.setPrice(subscription.getPrice());
        return subscription;
    }
}
