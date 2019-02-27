package ro.sci.teo.feb11.max;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BiggestNumberTest {

    private BiggestNumber max = new BiggestNumber();

    @Test
    public void getMaxBiggest() {
        //given
        int a = 6;
        int b = 20;
        //when
        int result = max.getMax(a, b);
        //then
        Assertions.assertEquals(20, result);
    }

    @Test
    public void getMaxEquals() {
        Assertions.assertEquals(5, max.getMax(5, 5));
    }
}