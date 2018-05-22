package com.els.back.services;


import com.els.back.com.enums.Punctuation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextServiceImplTest {

    @Test
    public void testGetPunctuationsNumber(){

        //given
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

        //when
        long count = text.chars().filter(ch -> ch == Punctuation.VIRGULE.toString().charAt(0)).count()
                + text.chars().filter(ch -> ch == Punctuation.POINT.toString().charAt(0)).count()
                + text.chars().filter(ch -> ch == Punctuation.POINT_VIRGULE.toString().charAt(0)).count()
                + text.chars().filter(ch -> ch == Punctuation.DEUX_POINTS.toString().charAt(0)).count()
                + text.chars().filter(ch -> ch == Punctuation.POINT_EXCLAMATION.toString().charAt(0)).count()
                + text.chars().filter(ch -> ch == Punctuation.POINT_INTERROGATION.toString().charAt(0)).count();

        //then
        assertEquals(3, count);

    }

}
