package ro.sci.teo.ian16.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TimeCheckTest {

    private TimeCheck timeCheck = new TimeCheck();

    @Test
    public void validateTimeTrue() {
        //given
        int h = 22;
        int min = 50;
        //when
        boolean timeOk = timeCheck.validateTime(h, min);
        //then
        Assertions.assertTrue(timeOk);
    }

    @Test
    public void validateTimeFalseHourTooBig() {
        //given
        int h = 24;
        int min = 50;
        //when
        boolean timeOk = timeCheck.validateTime(h, min);
        //then
        Assertions.assertFalse(timeOk);
    }

    @Test
    public void validateTimeFalseHourTooSmall() {
        //given
        int h = -1;
        int min = 50;
        //when
        boolean timeOk = timeCheck.validateTime(h, min);
        //then
        Assertions.assertFalse(timeOk);
    }

    @Test
    public void validateTimeFalseMinuteTooBig() {
        //given
        int h = 23;
        int min = 60;
        //when
        boolean timeOk = timeCheck.validateTime(h, min);
        //then
        Assertions.assertFalse(timeOk);
    }

    @Test
    public void validateTimeFalseMinuteTooSmall() {
        //given
        int h = 23;
        int min = -1;
        //when
        boolean timeOk = timeCheck.validateTime(h, min);
        //then
        Assertions.assertFalse(timeOk);
    }
}