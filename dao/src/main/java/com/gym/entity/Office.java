package com.gym.entity;

import java.util.Objects;

public class Office extends BaseEntity {

    private String name;

    private Integer coachId;

    private Integer roomId;

    public Office(String name, Integer coachId, Integer roomId) {
        this.name = name;
        this.coachId = coachId;
        this.roomId = roomId;
    }

    public Office(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(name, office.name) &&
                Objects.equals(coachId, office.coachId) &&
                Objects.equals(roomId, office.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coachId, roomId);
    }

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                ", coachId=" + coachId +
                ", roomId=" + roomId +
                '}';
    }
}
