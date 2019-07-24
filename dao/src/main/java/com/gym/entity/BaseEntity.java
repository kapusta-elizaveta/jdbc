package com.gym.entity;

public class BaseEntity {

    private Integer id;

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public BaseEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
