package com.gym.repository;

import com.gym.entity.Room;

import java.util.List;

public interface RoomRepository {

    void save(Room room);

    List<Room> findAll();

    Room findByName(String name);

    Room findById(Integer id);

    void deleteById(Integer id);
}
