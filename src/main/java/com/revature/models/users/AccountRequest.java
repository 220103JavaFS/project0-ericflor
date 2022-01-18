package com.revature.models.users;

import com.revature.models.accounts.Checking;
import com.revature.models.accounts.Savings;

import java.util.Objects;

public class AccountRequest {

    private boolean checking;
    private boolean savings;
    private String user_ssn;

    public AccountRequest(){

    }

    public AccountRequest(boolean checking, boolean savings, String user_ssn) {
        this.checking = checking;
        this.savings = savings;
        this.user_ssn = user_ssn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRequest that = (AccountRequest) o;
        return checking == that.checking && savings == that.savings && Objects.equals(user_ssn, that.user_ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checking, savings, user_ssn);
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "checking=" + checking +
                ", savings=" + savings +
                ", user_ssn='" + user_ssn + '\'' +
                '}';
    }
}
