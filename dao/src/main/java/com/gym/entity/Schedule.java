package com.gym.entity;

import java.util.Objects;

public class Schedule extends BaseEntity {

    private String startTime;

    private String endTime;

    private Integer officeId;

    private Integer roomId;

    public Schedule(String startTime, String endTime, Integer officeId, Integer roomId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.officeId = officeId;
        this.roomId = roomId;
    }

    public Schedule(){}

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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
        Schedule schedule = (Schedule) o;
        return Objects.equals(startTime, schedule.startTime) &&
                Objects.equals(endTime, schedule.endTime) &&
                Objects.equals(officeId, schedule.officeId) &&
                Objects.equals(roomId, schedule.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, officeId, roomId);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", officeId=" + officeId +
                ", roomId=" + roomId +
                '}';
    }
}
