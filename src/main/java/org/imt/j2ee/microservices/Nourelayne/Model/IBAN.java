package org.imt.j2ee.microservices.Nourelayne.Model;

import java.math.BigInteger;

import java.util.ResourceBundle;


public class IBAN {
    public static boolean isCheckDigitValid(String iban) {
        if (null == iban) return false;
        
        int validIBANLength = getValidIBANLength(iban);
        if (validIBANLength < 4) return false;
        if (iban.length() != validIBANLength) return false;
        
        BigInteger numericIBAN = getNumericIBAN(iban, false);

        int checkDigit = numericIBAN.mod(new BigInteger("97")).intValue();
        return checkDigit == 1;
    }
    
    public static int getValidIBANLength(String countryCode) {
        String code = countryCode.substring(0,2).toUpperCase();
        String length = ResourceBundle.getBundle(IBAN.class.getCanonicalName()).getString("length."+code);
        if (length == null) return -1;
        return Integer.valueOf(length).intValue();
    }
    
    private static BigInteger getNumericIBAN(String iban, boolean isCheckDigitAtEnd) {
        String endCheckDigitIBAN = iban;
        if (!isCheckDigitAtEnd) {
            //Move first four characters to end of string to put check digit at end
            endCheckDigitIBAN = iban.substring(4) + iban.substring(0, 4);
        }
        StringBuffer numericIBAN = new StringBuffer();
        for (int i = 0; i < endCheckDigitIBAN.length(); i++) {
            if (Character.isDigit(endCheckDigitIBAN.charAt(i))) {
                numericIBAN.append(endCheckDigitIBAN.charAt(i));
            } else {
                numericIBAN.append(10 + getAlphabetPosition(endCheckDigitIBAN.charAt(i)));
            }
        }
        
        return new BigInteger(numericIBAN.toString());
    }

    private static int getAlphabetPosition(char letter) {
        return Character.valueOf(Character.toUpperCase(letter)).compareTo(Character.valueOf('A'));
    }

}
