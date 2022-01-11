package com.revature.Models;

import java.util.Objects;

public class Customer { // open and view accounts

    private String firstName;
    private String lastname;
    private String username;
    private String password;
    private String ssn;
    private Account account;

    public Customer(){
    }

    public Customer(String firstName, String lastname, String username, String password, String ssn, Account account) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.ssn = ssn;
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastname, customer.lastname) && Objects.equals(username, customer.username) && Objects.equals(password, customer.password) && Objects.equals(ssn, customer.ssn) && Objects.equals(account, customer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastname, username, password, ssn, account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ssn='" + ssn + '\'' +
                ", account=" + account +
                '}';
    }
}
