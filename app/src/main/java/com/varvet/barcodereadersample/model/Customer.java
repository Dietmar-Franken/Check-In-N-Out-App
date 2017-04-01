package com.varvet.barcodereadersample.model;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class Customer extends User {

    private int phoneNumber;

    public Customer(String email, String password, String firstName, String lastName, Role role, int userId, int phoneNumber) {
        super(email, password, firstName, lastName, role, userId);
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Customer{" +
                "phoneNumber=" + phoneNumber +
                '}';
    }
}
