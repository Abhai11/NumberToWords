package com.learning.test;

import java.util.ArrayList;
import java.util.List;

public class NumberToWordsConverterImpl implements NumberToWordsConverter {
    private static final String[] ONES_WORDS = {"Zero", "one",
            "two", "three", "four",
            "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
    //Adding empty strings at starting in order to access values directly
    private static final String[] TENS_WORDS = {"", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    private static final String[] SUFFIX = {"", " thousand", " million", " billion"};

    private int count;

    /**
     * Implementation to get the word representation of a number. Currently supported till Integer.MAX_VALUE
     * Number is broken into triple digit numbers and it's hundred's, ten's and unit's place is calculated and appended to the string
     * with required SUFFIX(Thousand,Million...)
     * @param number
     * @return
     */
    @Override
    public String toWords(final int number) {
        List<Integer> numList = new ArrayList<>();
        int copyNum = number;
        count = -1;

        if (copyNum == 0)
            return ONES_WORDS[0];

        while (copyNum > 0) {
            numList.add(copyNum % 1000);
            copyNum = copyNum / 1000;
            count++;
        }

        StringBuilder word = new StringBuilder();

        for (int i = numList.size() - 1; i >= 0; i--) {
            word.append(numberRepresentationHundredDigit(numList.get(i), i)).append(" ");
        }

        return word.toString().trim();
    }

    private String numberRepresentationDoubleDigit(int number) {
        if (number <= 19) {
            return ONES_WORDS[number];
        } else {
            StringBuilder word = new StringBuilder();
            int pos1 = number / 10;
            int pos2 = number % 10;
            word.append(TENS_WORDS[pos1]);
            if (pos2 > 0) {
                word.append(" ").append(ONES_WORDS[pos2]);
            }
            return word.toString();
        }
    }

    private String numberRepresentationHundredDigit(int number, int suffixIndex) {
        StringBuilder word = new StringBuilder();
        int pos1 = number / 100;
        if (pos1 > 0) {
            word.append(ONES_WORDS[pos1]);
            word.append(" hundred ");
            count = 1;
        }
        int pos2 = number % 100;
        if (pos2 > 0) {
            if (suffixIndex == 0 && count > 0)
                word.append("and ");
            word.append(numberRepresentationDoubleDigit(pos2));
        }
        word.append(SUFFIX[suffixIndex]);
        return word.toString();
    }
}
