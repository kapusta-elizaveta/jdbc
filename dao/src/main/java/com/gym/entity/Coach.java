package com.gym.entity;

import java.util.Objects;

public class Coach extends BaseEntity {

    private String email;

    private String name;

    private String phoneNumber;

    public Coach(String email, String name, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Coach(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(email, coach.email) &&
                Objects.equals(name, coach.name) &&
                Objects.equals(phoneNumber, coach.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
