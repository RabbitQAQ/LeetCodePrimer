package com.rabbit.solution.tests;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;

public class ParkingLotSolution {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}

enum ParkingSlotType {
    SMALL,
    MEDIUM,
    LARGE
}

abstract class Vehicle {
    private ParkingSlotType pType;
    private int id;
    public Vehicle(ParkingSlotType pType) {
        this.pType = pType;
    }
    public ParkingSlotType getParkingSlotType() {
        return this.pType;
    }
}

class ParkingSlot {
    private long startTime;
    private long endTime;
    private ParkingSlotType pType;
    public ParkingSlot(ParkingSlotType pt) {
        this.pType = pt;
    }
    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    public double getFee() {
        double res = (endTime - startTime) / 1000.0 / 60 * 0.1;
        endTime = 0;
        startTime = 0;
        return res;
    }
}

class ParkingLot {
    LinkedList<ParkingSlot> smallSlot;
    LinkedList<ParkingSlot> mediumSlot;
    LinkedList<ParkingSlot> largeSlot;

    public ParkingLot() {
        this.smallSlot = new LinkedList<ParkingSlot>();
        this.mediumSlot = new LinkedList<ParkingSlot>();
        this.largeSlot = new LinkedList<ParkingSlot>();
    }

    public boolean allocParkingSlot(Vehicle v) {
        switch (v.getParkingSlotType()) {
            case SMALL:break;
            case MEDIUM:break;
            case LARGE:break;
        }

        return false;
    }
}
