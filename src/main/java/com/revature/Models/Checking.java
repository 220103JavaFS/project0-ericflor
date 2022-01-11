package com.revature.Models;

public class Checking extends Account{

    private static String accountType = "Checking";

    public Checking(){

    }

    public Checking(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
    }

    public static String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        Checking.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account Type: " + accountType + " Account" +
                "Account Number: " + this.getAccountNumber() +
                "Balance: " + this.getBalance() ;
    }


}
