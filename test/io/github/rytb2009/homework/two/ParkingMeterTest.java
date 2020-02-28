package io.github.rytb2009.homework.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingMeterTest {

    @Test
    void insertQuarter() throws Exception {
        int maxTime = 10;
        int minutesPerQuarter = 2;
        ParkingMeter pm = new ParkingMeter(maxTime , minutesPerQuarter);
        int insertingQuarter = 3;
        pm.insertQuarter(insertingQuarter);
        assertEquals(6, pm.getTime());
    }

    @Test
    void insertQuarter_ExceedMaxTime() {
        int maxTime = 10;
        int minutesPerQuarter = 2;
        ParkingMeter pm = new ParkingMeter(maxTime , minutesPerQuarter);
        int insertingQuarter = 6;
        pm.insertQuarter(insertingQuarter);
        assertEquals(10, pm.getTime());
    }
}