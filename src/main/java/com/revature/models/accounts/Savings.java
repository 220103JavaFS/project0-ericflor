package com.revature.models.accounts;

import java.util.Objects;

public class Savings {

    private double balance;
    private String customerSSN;
    private String customerFirstName;
    private String customerLastName;
    private double amount;

    public Savings(){

    }

    public Savings(double balance, String customerSSN) {
        this.balance = balance;
        this.customerSSN = customerSSN;
    }

    public Savings(double balance, String customerSSN, double amount) {
        this.balance = balance;
        this.customerSSN = customerSSN;
        this.amount = amount;
    }

    public Savings(double balance, String customerSSN, String customerFirstName, String customerLastName) {
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
        Savings savings = (Savings) o;
        return Double.compare(savings.balance, balance) == 0 && Double.compare(savings.amount, amount) == 0 && Objects.equals(customerSSN, savings.customerSSN) && Objects.equals(customerFirstName, savings.customerFirstName) && Objects.equals(customerLastName, savings.customerLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, customerSSN, customerFirstName, customerLastName, amount);
    }

    @Override
    public String toString() {
        return "Savings{" +
                "balance=" + balance +
                ", customerSSN='" + customerSSN + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
