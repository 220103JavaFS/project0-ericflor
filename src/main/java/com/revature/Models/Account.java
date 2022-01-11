package com.revature.Models;

import java.util.Objects;

public class Account {

    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 301457890;

    public Account(){
        accountNumber = numberOfAccounts++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, accountNumber);
    }
}
