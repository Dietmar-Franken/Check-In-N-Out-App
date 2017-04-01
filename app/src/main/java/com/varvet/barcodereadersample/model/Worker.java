package com.varvet.barcodereadersample.model;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class Worker extends User {
    private int roomNumber;
    private int phoneNumber;

    public Worker(String firstName, String lastName, Role role, int userId, int roomNumber, int phoneNumber) {
        super(firstName, lastName, role, userId);
        this.roomNumber = roomNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Worker{" +
                "roomNumber=" + roomNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
