package com.learning.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNumberToWords {

    NumberToWordsConverter converter;

    @Before
    public void setUp(){
        converter = new NumberToWordsConverterImpl();
    }

    @Test
    public void testConversionOneDigit(){
        Assert.assertEquals("Zero",converter.toWords(0));
        Assert.assertEquals("nine",converter.toWords(9));
    }

    @Test
    public void testConversionTwoDigit() {
        Assert.assertEquals("nineteen",converter.toWords(19));
        Assert.assertEquals("fifty nine", converter.toWords(59));
    }

    @Test
    public void testConversionThreeDigit() {
        Assert.assertEquals("five hundred and nine", converter.toWords(509));
        Assert.assertEquals("nine hundred and ninety nine",converter.toWords(999));
    }

    @Test
    public void testConversionFourDigit() {
        Assert.assertEquals("nine thousand nine hundred and ninety nine", converter.toWords(9999));
        Assert.assertEquals("one thousand", converter.toWords(1000));
        Assert.assertEquals("five thousand three hundred and eighty nine", converter.toWords(5389));
        Assert.assertEquals("seven thousand and twenty one", converter.toWords(7021));
    }

    @Test
    public void testConversionFiveDigit() {
        Assert.assertEquals("seventy thousand", converter.toWords(70000));
        Assert.assertEquals("ten thousand and nine", converter.toWords(10009));
        Assert.assertEquals("eighteen thousand two hundred and ninety three", converter.toWords(18293));
        Assert.assertEquals("ninety nine thousand nine hundred and ninety nine", converter.toWords(99999));
        Assert.assertEquals("eleven thousand one hundred and eleven", converter.toWords(11111));
    }

    @Test
    public void testConversionMaxInt() {
        Assert.assertEquals("two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty seven", converter.toWords(Integer.MAX_VALUE));
    }
}
