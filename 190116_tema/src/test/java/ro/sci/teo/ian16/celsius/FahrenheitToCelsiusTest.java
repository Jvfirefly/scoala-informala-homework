package ro.sci.teo.ian16.celsius;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FahrenheitToCelsiusTest {

    private FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();

    @Test
    public void convertToCelsiusDefault() {
        //given
        double fahrenheit = 20;
        //when
        double celsius = fahrenheitToCelsius.convertToCelsius(fahrenheit);
        //then
        Assertions.assertEquals(-6.67, celsius);
    }

    @Test
    public void convertToCelsiusZero() {
        //given
        double fahrenheit = 32;
        //when
        double celsius = fahrenheitToCelsius.convertToCelsius(fahrenheit);
        //then
        Assertions.assertEquals(0, celsius);
    }

    @Test
    public void round() {
        Assertions.assertEquals(23.23, fahrenheitToCelsius.round(23.23232323));
    }

    @Test
    public void roundUp() {
        Assertions.assertEquals(23.57, fahrenheitToCelsius.round(23.56666666));
    }
}