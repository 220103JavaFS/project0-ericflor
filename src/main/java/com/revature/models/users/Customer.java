package com.revature.models.users;


import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;

import java.util.Objects;

public class Customer extends User {

    private String ssn;
    private String firstName;
    private String lastName;
    // private Checking checking;
    //private Savings savings;

    public Customer (){

    }

    public Customer(String username, String password, String ssn, String firstName, String lastName) {
        super(username, password);
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public Customer(String username, String password, String ssn, String firstName, String lastName, Checking checking, Savings savings) {
//        super(username, password);
//        this.ssn = ssn;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.checking = checking;
//        this.savings = savings;
//    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Checking getChecking() {
//        return checking;
//    }
//
//    public void setChecking(Checking checking) {
//        this.checking = checking;
//    }
//
//    public Savings getSavings() {
//        return savings;
//    }
//
//    public void setSavings(Savings savings) {
//        this.savings = savings;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ssn, customer.ssn) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +

                '}';
    }
}
