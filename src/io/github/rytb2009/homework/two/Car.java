package io.github.rytb2009.homework.two;

public class Car {
    private double fuelEfficiency; // miles/gallon
    private double gas;

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void drive(double distanceInMiles) throws Exception {
        double gasConsume = distanceInMiles / fuelEfficiency;
        if (gasConsume > this.gas) {
            throw new Exception("Gas is not enough, please refuel.");
        }
        this.gas -= gasConsume;
    }

    public void addGas(double gas) {
        this.gas += gas;
    }

    public double getGas() {
        return this.gas;
    }
}
