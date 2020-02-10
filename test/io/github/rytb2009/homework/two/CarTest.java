package io.github.rytb2009.homework.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void drive() throws Exception {
        double efficiency = 30d;
        Car car = new Car(efficiency);
        car.addGas(1);
        car.drive(30);
        assertEquals(car.getGas(), 0d);

        car.addGas(2);
        car.drive(15);
        assertEquals(1.5, car.getGas());
    }

    @Test
    void drive_NoGas() {
        double efficiency = 30d;
        Car car = new Car(efficiency);
        Exception exception = assertThrows(Exception.class, () -> {
            car.drive(1);
        });
        String expectedMessage = "Gas is not enough, please refuel.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}