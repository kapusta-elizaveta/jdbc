package com.gym.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
public class Client extends BaseEntity{

    private String email;

    private String login;

    private String name;

    private String password;

    private String phoneNumber;

    private Integer officeId;

    public Client(String email, String login, String name, String password,
                  String phoneNumber, Integer officeId) {
        this.email = email;
        this.login = login;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.officeId = officeId;
    }

    public Client(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email) &&
                Objects.equals(login, client.login) &&
                Objects.equals(name, client.name) &&
                Objects.equals(password, client.password) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(officeId, client.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, login, name, password, phoneNumber, officeId);
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", officeId=" + officeId +
                '}';
    }
}
