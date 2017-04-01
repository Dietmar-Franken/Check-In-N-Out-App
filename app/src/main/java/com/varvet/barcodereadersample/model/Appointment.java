package com.varvet.barcodereadersample.model;

import java.util.Date;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class Appointment {
    private Customer customer;
    private Worker worker;
    private int roomNumber;
    private Date time;

    public Appointment(Customer customer, Worker worker, Date time) {
        this.customer = customer;
        this.worker = worker;
        this.time = time;
        this.roomNumber = worker.getRoomNumber();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment that = (Appointment) o;

        if (roomNumber != that.roomNumber) return false;
        if (!customer.equals(that.customer)) return false;
        if (!worker.equals(that.worker)) return false;
        return time.equals(that.time);

    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + worker.hashCode();
        result = 31 * result + roomNumber;
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "customer=" + customer +
                ", worker=" + worker +
                ", roomNumber=" + roomNumber +
                ", time=" + time +
                '}';
    }
}
