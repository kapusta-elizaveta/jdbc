package com.gym.service;

import com.gym.dto.OfficeDto;
import com.gym.entity.Office;

import java.util.List;

public interface OfficeService {

    List<Office> findAll();

    Office findById(Integer id);

    Office findByName(String name);

    List<Office> findByCoachId(Integer id);

    void save(OfficeDto officeDto);

    void deleteById(Integer id);
}
