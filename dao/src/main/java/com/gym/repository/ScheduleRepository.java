package com.gym.repository;

import com.gym.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    void save(Schedule schedule);

    List<Schedule> findByOfficeId(Integer id);

    List<Schedule> findByRoomId(Integer id);

    List<Schedule> findAll();

    Schedule findById(Integer id);

    void deleteById(Integer id);
}
