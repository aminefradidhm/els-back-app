package com.els.back.com.enums;

/*
Enumeration of punctuations
 */
public enum Punctuation {

    VIRGULE(","),
    POINT("."),
    POINT_VIRGULE(";"),
    DEUX_POINTS(":"),
    POINT_EXCLAMATION("!"),
    POINT_INTERROGATION("?");


    private String value;

    Punctuation(String value)
    {
        this.value = value;
    }

    public String toString()
    {
        return this.value; //will return , or . instead of VIRGULE or POINT
    }

}
