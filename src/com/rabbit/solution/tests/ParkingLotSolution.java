package com.rabbit.solution.tests;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static com.rabbit.solution.tests.ParkingSpaceType.*;

public class ParkingLotSolution {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}

abstract class Vehicle {
    protected ParkingSpace pSpace;

    public abstract boolean park(ParkingLot pLot);

    public boolean unpark(ParkingLot pLot) {
        if (pSpace != null) {
            pLot.reclaimFreeSpace(pSpace);
            return true;
        }
        return false;
    }
}

class Cars extends Vehicle {

    @Override
    public boolean park(ParkingLot pLot) {
        if ((pSpace = pLot.allocateFreeSpace(ParkingSpaceType.CAR)) == null)
            return true;
        else
            return false;
    }
}

class Motorbike extends Vehicle {
    @Override
    public boolean park(ParkingLot pLot) {
        if ((pSpace = pLot.allocateFreeSpace(ParkingSpaceType.MOTOBIKE)) == null)
            return true;
        else
            return false;
    }

}

class HandicappedCars extends Vehicle {

    @Override
    public boolean park(ParkingLot pLot) {
        if ((pSpace = pLot.allocateFreeSpace(ParkingSpaceType.HANDICAPPED)) == null)
            return true;
        else
            return false;
    }
}

enum ParkingSpaceType {
    MOTOBIKE, CAR, HANDICAPPED;
}

class ParkingSpace {

    private int id;
    private ParkingSpaceType pSpaceType;
    private ParkingMeter meter;

    public ParkingSpace(int id, ParkingSpaceType pspaceType) {
        super();
        this.id = id;
        this.pSpaceType = pspaceType;
    }

    public int getId() {
        return id;
    }

    public void setStart() {
        meter.start = new GregorianCalendar();
    }

    public void setEnd() {
        meter.end = new GregorianCalendar();
    }

    public ParkingSpaceType getpSpaceType() {
        return pSpaceType;
    }

    private class ParkingMeter {
        public GregorianCalendar start;
        public GregorianCalendar end;
    }

    public float getFee() {
        return 0;
    }

}

class ParkingLot {

    private List<ParkingSpace> freeRegularSpace;
    private List<ParkingSpace> freeCompactSpace;
    private List<ParkingSpace> freeHandicappedSpace;

    public ParkingLot() {
    }

    public ParkingSpace allocateFreeSpace(ParkingSpaceType pSpaceType){
        ParkingSpace pSpace = null;

        switch (pSpaceType) {
            case MOTOBIKE:
                if (freeRegularSpace.size() == 0)
                    return null;
                pSpace = freeRegularSpace.remove(0);
                pSpace.setStart();
                break;

            case HANDICAPPED:
                if (freeHandicappedSpace.size() == 0)
                    return null;
                pSpace = freeHandicappedSpace.remove(0);
                pSpace.setStart();
                break;

            case CAR:
                if (freeCompactSpace.size() == 0)
                    return null;
                pSpace = freeCompactSpace.remove(0);
                pSpace.setStart();
                break;

            default:
                break;
        }
        return pSpace;
    }

    public float reclaimFreeSpace(ParkingSpace Space) {
        Space.setEnd();
        switch (Space.getpSpaceType()) {
            case MOTOBIKE:
                freeRegularSpace.add(Space);
                break;

            case CAR:
                freeCompactSpace.add(Space);
                break;

            case HANDICAPPED:
                freeHandicappedSpace.add(Space);
                break;

            default:
                break;
        }
        return Space.getFee();
    }

}