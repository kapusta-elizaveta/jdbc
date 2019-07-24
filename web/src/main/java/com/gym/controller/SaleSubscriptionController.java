package com.gym.controller;

import com.gym.dto.SaleSubscriptionDto;
import com.gym.entity.SaleSubscription;
import com.gym.service.SaleSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saleSubscriptions")
public class SaleSubscriptionController {

    private final SaleSubscriptionService saleSubscriptionService;

    @Autowired
    public SaleSubscriptionController(SaleSubscriptionService saleSubscriptionService) {
        this.saleSubscriptionService = saleSubscriptionService;
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<SaleSubscription> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(saleSubscriptionService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/clientId/{client_id}")
    ResponseEntity<List<SaleSubscription>> findByClientId(@PathVariable("client_id") Integer id){
        return new ResponseEntity<>(saleSubscriptionService.findByClientId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/subscription_id/{subscriptions_id}")
    ResponseEntity<List<SaleSubscription>> findBySubscriptionId(@PathVariable("subscriptions_id") Integer id){
        return new ResponseEntity<>(saleSubscriptionService.findBySubscriptionId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> save(@Validated @RequestBody SaleSubscriptionDto saleSubscriptionDto){
        saleSubscriptionService.save(saleSubscriptionDto);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id){
        saleSubscriptionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
