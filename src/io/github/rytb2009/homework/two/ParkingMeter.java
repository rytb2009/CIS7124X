package io.github.rytb2009.homework.two;

public class ParkingMeter {
    private int maxTime; // unit - minutes
    private int rate; // unit - minutes per quarter
    private int time; // unit - minutes

    public ParkingMeter(int maxTime,  int rate) {
        this.maxTime = maxTime;
        this.rate = rate;
    }

    public void insertQuarter(int quantity) throws Exception {
        this.time = Math.min(quantity * this.rate, this.maxTime);
    }

    public int getTime() {
        return this.time;
    }
}
