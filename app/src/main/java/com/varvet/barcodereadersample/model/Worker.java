package com.varvet.barcodereadersample.model;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class Worker extends User {
    private String room;
    private int phoneNumber;

    public Worker(String email, String password, String firstName, String lastName, int userId, String room, int phoneNumber) {
        super(email, password, firstName, lastName, Role.Worker, userId);
        this.room = room;
        this.phoneNumber = phoneNumber;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
                "room=" + room +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
