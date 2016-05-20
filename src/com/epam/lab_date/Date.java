package com.epam.lab_date;

import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Class for working with date format.
 */
public class Date {

    private int day;
    private int month;
    private int year;

    /**
     * Constructor with parameters.
     *
     * @param day Day of the given date.
     * @param month Month of the given date.
     * @param year Year of the given date.
     */
    public Date(int day, int month, int year) {
        checkDate(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Constructor with parameters.
     *
     * @param date Given date in format dd[delimiter]mm[delimiter]year
     * @param delimiter Delimiter that separate parts of given date.
     */
    public Date(String date, String delimiter) {
        checkDate(date, delimiter);

        String[] dates = splitDate(date, delimiter);

        day = Integer.valueOf(dates[0]);
        month = Integer.valueOf(dates[1]);
        year = Integer.valueOf(dates[2]);
    }

    /**
     * Increases stored date by one day.
     */
    public void increaseByDay() {
        checkDate(day + 1, month, year);

        day++;
    }

    /**
     * Decreases stored date by one day.
     */
    public void decreaseByDay() {
        checkDate(day - 1, month, year);

        day--;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        checkDate(day, month, year);

        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        checkDate(day, month, year);

        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkDate(day, month, year);

        this.year = year;
    }

    /**
     * Returns stored date in format dd[delimiter]mm[delimiter]year
     *
     * @param delimiter Delimiter to separate parts of date.
     * @return Formatted date.
     */
    public String getFormattedDate(String delimiter) {
        try {
            SimpleDateFormat sdf =
                    new SimpleDateFormat("dd" + delimiter + "MM" + delimiter + "yyyy");
            sdf.setLenient(false);
            return sdf.format(sdf.parse(day + delimiter + month + delimiter + year));
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }

        Date thatDate = (Date) that;

        if (this.day != thatDate.day) {
            return false;
        }
        if (this.month != thatDate.month) {
            return false;
        }
        if (this.year != thatDate.year) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;

        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + getDay() +
                ", month=" + getMonth() +
                ", year=" + getYear() +
                '}';
    }

    /**
     * Checks if input date is correct.
     *
     * @param day Day of the given date.
     * @param month Month of the given date.
     * @param year Year of the given date.
     */
    private void checkDate(int day, int month, int year) {
        checkDate(day + "." + month + "." + year, ".");
    }

    /**
     * Checks if input date is correct.
     *
     * @param date Given date in format dd[delimiter]mm[delimiter]year
     * @param delimiter Delimiter that separate parts of given date.
     *
     * @throws IllegalArgumentException if date has incorrect format.
     */
    private void checkDate(String date, String delimiter) {
        try {
            SimpleDateFormat sdf =
                    new SimpleDateFormat("dd" + delimiter + "MM" + delimiter + "yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date is incorrect!");
        }
    }

    /**
     * Splits date string in format dd[delimiter]mm[delimiter]year by given delimiter.
     *
     * @param date Given date in format dd[delimiter]mm[delimiter]year
     * @param delimiter Delimiter that separate parts of given date.
     *
     * @return Array of strings that consists of day, month and year.
     */
    private String[] splitDate(String date, String delimiter) {
        return date.split("\\" + delimiter);
    }
}
