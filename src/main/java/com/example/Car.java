package com.example;

import java.io.Serializable;

public class Car implements Serializable {
    private int vehicleNo;
    private String color;

    public Car() {
        this.vehicleNo = 100;
        this.color = "Red";
    }

    public Car(int vehicleNo, String color) {
        this.vehicleNo = vehicleNo;
        this.color = color;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
