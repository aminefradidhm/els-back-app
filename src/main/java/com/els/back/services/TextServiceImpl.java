package com.els.back.services;

import com.els.back.enums.Punctuation;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService{

    @Override
    public long getPunctuationsNumber(String text){

        return text.chars().filter(ch -> ch == Punctuation.VIRGULE.toString().charAt(0)).count()
        + text.chars().filter(ch -> ch == Punctuation.POINT.toString().charAt(0)).count()
        + text.chars().filter(ch -> ch == Punctuation.POINT_VIRGULE.toString().charAt(0)).count()
        + text.chars().filter(ch -> ch == Punctuation.DEUX_POINTS.toString().charAt(0)).count()
        + text.chars().filter(ch -> ch == Punctuation.POINT_EXCLAMATION.toString().charAt(0)).count()
        + text.chars().filter(ch -> ch == Punctuation.POINT_INTERROGATION.toString().charAt(0)).count();

    }

}
