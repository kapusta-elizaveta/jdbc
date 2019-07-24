package com.gym.repository;

import com.gym.entity.Office;

import java.util.List;

public interface OfficeRepository {

    void save(Office office);

    List<Office> findAll();

    Office findById(Integer id);

    Office findByName(String name);

    List<Office> findByCoachId(Integer id);

    void deleteById(Integer id);
}
