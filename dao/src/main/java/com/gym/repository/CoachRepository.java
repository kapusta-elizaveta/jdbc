package com.gym.repository;

import com.gym.entity.Coach;

import java.util.List;

public interface CoachRepository {

    void save(Coach coach);

    List<Coach> findAll();

    List<Coach> findByName(String name);

    Coach findById(Integer id);

    void deleteById(Integer id);
}
