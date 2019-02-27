package ro.sci.teo.feb11.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCheckTest {
    private TimeCheck tc = new TimeCheck();

    @Test
    public void ValidateTimeTrue() {
        //given
        int hour = 23;
        int minute = 20;

        //when
        boolean timeOk = tc.validateTime(hour, minute);

        //then
        Assertions.assertTrue(timeOk);
    }

    @Test
    public void validateTimeFalseHourTooBig() {
        //given
        int hour = 25;
        int minute = 20;

        //then
        assertThrows(IllegalArgumentException.class,
                () -> {                                 //()-> e o lambda function
                    tc.validateTime(hour, minute);
                });
    }

    @Test
    public void validateTimeFalseHourTooSmall() {
        //given
        int hour = -1;
        int minute = 50;

        //then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tc.validateTime(hour, minute);
                });
    }

    @Test
    public void validateTimeFalseMinuteTooBig() {
        //given
        int hour = 23;
        int minute = 60;

        //then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tc.validateTime(hour, minute);
                });
    }

    @Test
    public void validateTimeFalseMinuteTooSmall() {
        //given
        int hour = 23;
        int minute = -1;

        //when
        assertThrows(IllegalArgumentException.class,
                () -> {
                    tc.validateTime(hour, minute);
                });
    }
}