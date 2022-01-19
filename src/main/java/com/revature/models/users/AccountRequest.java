package com.revature.models.users;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;

import java.util.Objects;

public class AccountRequest {

    private boolean checking;
    private boolean savings;
    private String user_ssn;
    private double initialDeposit;
    // FIX THIS SO IT HAS TWO DEPOSIT FIELDS FOR CHECKING AND SAVINGS
    public AccountRequest(){

    }

    public AccountRequest(boolean checking, boolean savings, String user_ssn, double initialDeposit) {
        this.checking = checking;
        this.savings = savings;
        this.user_ssn = user_ssn;
        this.initialDeposit = initialDeposit;
    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public boolean isSavings() {
        return savings;
    }

    public void setSavings(boolean savings) {
        this.savings = savings;
    }

    public String getUser_ssn() {
        return user_ssn;
    }

    public void setUser_ssn(String user_ssn) {
        this.user_ssn = user_ssn;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRequest that = (AccountRequest) o;
        return checking == that.checking && savings == that.savings && Double.compare(that.initialDeposit, initialDeposit) == 0 && Objects.equals(user_ssn, that.user_ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checking, savings, user_ssn, initialDeposit);
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "checking=" + checking +
                ", savings=" + savings +
                ", user_ssn='" + user_ssn + '\'' +
                ", initialDeposit=" + initialDeposit +
                '}';
    }
}
