package com.revature.models.users;

import java.util.Objects;

public class Teller extends User{

    private int TellerId;

    public Teller(){

    }

    public Teller(int tellerId) {
        TellerId = tellerId;
    }

    public Teller(String username, String password, int tellerId) {
        super(username, password);
        TellerId = tellerId;
    }

    public int getTellerId() {
        return TellerId;
    }

    public void setTellerId(int tellerId) {
        TellerId = tellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teller teller = (Teller) o;
        return TellerId == teller.TellerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TellerId);
    }

    @Override
    public String toString() {
        return "Teller{" +
                "TellerId=" + TellerId +
                '}';
    }
}
