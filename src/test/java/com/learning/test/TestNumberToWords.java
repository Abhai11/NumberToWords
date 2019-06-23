package com.learning.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestNumberToWords {

    @Test
    public void testLogic(){
        NumberToWordsConverter converter = new NumberToWordsConverterImpl();
        System.out.println(converter.toWords(100));
        System.out.println(converter.toWords(599));
        System.out.println(converter.toWords(999));
        System.out.println(converter.toWords(999));
        System.out.println(converter.toWords(9999));
        System.out.println(converter.toWords(1000));
        System.out.println(converter.toWords(5389));
        System.out.println(converter.toWords(7000));
        System.out.println(converter.toWords(70000));
        System.out.println(converter.toWords(10000));
        System.out.println(converter.toWords(18293));
        System.out.println(converter.toWords(99999));
        System.out.println(converter.toWords(11111));
    }

    @Test
    public void testConversionTill99(){
        NumberToWordsConverter converter = new NumberToWordsConverterImpl();
        Assert.assertTrue(converter.toWords(0).equals("Zero"));
        Assert.assertTrue(converter.toWords(9).equals("nine"));
        Assert.assertTrue(converter.toWords(11).equals("eleven"));
        Assert.assertTrue(converter.toWords(20).equals("twenty"));
        Assert.assertTrue(converter.toWords(21).equals("twenty one"));
        Assert.assertTrue(converter.toWords(59).equals("fifty nine"));
        Assert.assertTrue(converter.toWords(99).equals("ninety nine"));
    }
}
