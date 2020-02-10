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
        int payTime = quantity * this.rate;
        if (payTime > this.maxTime) {
            throw new Exception("Transaction failed: exceed max parking time.");
        }
        this.time = payTime;
    }

    public int getTime() {
        return this.time;
    }
}
