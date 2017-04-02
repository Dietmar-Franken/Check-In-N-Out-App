package com.varvet.barcodereadersample.model;

import java.util.Date;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class Appointment {
    private Customer customer;
    private Worker worker;
    private String room;
    private Date time;
    private int id;

    public Appointment(Customer customer, Worker worker, Date time, int id) {
        this.customer = customer;
        this.worker = worker;
        this.room = worker.getRoom();
        this.time = time;
        this.id = id;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;

        Appointment that = (Appointment) o;

        if (id != that.id) return false;
        if (!customer.equals(that.customer)) return false;
        if (!worker.equals(that.worker)) return false;
        if (!room.equals(that.room)) return false;
        return time.equals(that.time);

    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + worker.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "customer=" + customer +
                ", worker=" + worker +
                ", room='" + room + '\'' +
                ", time=" + time +
                ", id=" + id +
                '}';
    }
}
