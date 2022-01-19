package com.revature.models.accounts;

import com.revature.models.users.Customer;

import java.util.Objects;

public class Checking {

    private double balance;
    private String customerSSN;
    private String customerFirstName;
    private String customerLastName;
    private double amount;

    public Checking(){

    }

    public Checking(double balance, String customerSSN) {
        this.balance = balance;
        this.customerSSN = customerSSN;
    }

    public Checking(double balance, String customerSSN, double amount) {
        this.balance = balance;
        this.customerSSN = customerSSN;
        this.amount = amount;
    }

    public Checking(double balance, String customerSSN, String customerFirstName, String customerLastName) {
        this.balance = balance;
        this.customerSSN = customerSSN;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checking checking = (Checking) o;
        return Double.compare(checking.balance, balance) == 0 && Double.compare(checking.amount, amount) == 0 && Objects.equals(customerSSN, checking.customerSSN) && Objects.equals(customerFirstName, checking.customerFirstName) && Objects.equals(customerLastName, checking.customerLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, customerSSN, customerFirstName, customerLastName, amount);
    }

    @Override
    public String toString() {
        return "Checking{" +
                "balance=" + balance +
                ", customerSSN='" + customerSSN + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", amount=" + amount +
                '}';
    }
}


