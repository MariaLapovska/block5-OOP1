package com.epam.lab_date;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Asus on 19.05.2016.
 */
public class DateTest {

    Date date = new Date("30.04.2015", ".");

    @Test(expected = IllegalArgumentException.class)
    public void increaseByDay() {
        date.increaseByDay();
    }

    @Test
    public void decreaseByDay() {
        date.decreaseByDay();

        assertEquals("Date decreased by day", "29.04.2015", date.getFormattedDate("."));
    }

    @Test
    public void getFormattedDate() {
        assertEquals("Formatted date", "30/04/2015", date.getFormattedDate("/"));
    }

    @Test
    public void equals() {
        assertTrue(date.equals(new Date("30.04.2015", ".")));
    }
}