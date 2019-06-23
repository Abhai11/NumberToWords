package com.learning.test;

public class NumberToWordsConverterImpl implements NumberToWordsConverter {
    String[] STRING_SINGLE = {"Zero", "one",
            "two", "three", "four",
            "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
    //Adding empty strings at starting in order to access values directly
    String[] String_TENS = {"", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    @Override
    public String toWords(int number) {
        String wordRepresentation = "";
        if (number >= 0 && number <= 99) {
            wordRepresentation = numberRepresentationDoubleDigit(number);
        } else if (number > 99 && number <= 999) {
            wordRepresentation = numberRepresentationTripleDigit(number);
        } else if (number >999 && number <= 99999){
            wordRepresentation = numberRepresentationThousands(number);
        }
        return wordRepresentation;
    }

    private String numberRepresentationDoubleDigit(int number) {
        if (number >= 0 && number <= 19) {
            return STRING_SINGLE[number];
        } else {
            StringBuilder word = new StringBuilder();
            int pos1 = number / 10;
            int pos2 = number % 10;
            word.append(String_TENS[pos1]);
            if (pos2 > 0) {
                word.append(" " + STRING_SINGLE[pos2]);
            }
            return word.toString();
        }
    }

    private String numberRepresentationTripleDigit(int number) {
        StringBuilder word = new StringBuilder();
        int pos1 = number / 100;
        word.append(STRING_SINGLE[pos1]);
        word.append(" hundred");
        int pos2 = number % 100;
        if (pos2 > 0) {
            word.append(" and ");
            word.append(numberRepresentationDoubleDigit(pos2));
        }
        return word.toString();
    }

    private String numberRepresentationThousands(int number) {
        StringBuilder word = new StringBuilder();
        int pos1 = number / 1000;
        word.append(numberRepresentationDoubleDigit(pos1));
        word.append(" thousand");
        int pos2 = number % 1000;
        if (pos2 > 0) {
            word.append(" ");
            word.append(numberRepresentationTripleDigit(pos2));
        }
        return word.toString();
    }

}
