package ro.sci.teo.mar06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class PlaygroundTest {
    private Playground playground = new Playground();

    @Test
    void validateMonthTrue() {
        Assertions.assertTrue(playground.validateMonth(2));
    }

    @Test
    void validateMonthTooSmall() {
        Assertions.assertFalse(playground.validateMonth(-1));
    }

    @Test
    void validateMonthTooBig() {
        Assertions.assertFalse(playground.validateMonth(13));
    }

    @Test
    void stringToLocalDateTrue() {
        //given
        String dateStr = "16-09-1992";
        //when
        LocalDate date = playground.stringToLocalDate(dateStr);
        //then
        Assertions.assertEquals(LocalDate.of(1992, 9, 16), date);
    }
}