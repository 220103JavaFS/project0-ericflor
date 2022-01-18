package com.revature.models.users;

import java.util.Objects;

public class Manager extends User{

    private int managerId;

    public Manager(){

    }

    public Manager(String username, String password, int managerId) {
        super(username, password);
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return managerId == manager.managerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", numOfRequests=" +
                '}';
    }
}
