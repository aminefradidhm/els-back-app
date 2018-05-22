package com.els.back.controllers;

import com.els.back.services.TextService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TextControllerTest {

    @Mock
    TextService textServiceMock;

    @InjectMocks
    TextController textController;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(textController)
                .build();
    }


    @Test
    public void testGetPunctuationNumber() throws Exception {

        //given
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

        // when
        when(textServiceMock.getPunctuationsNumber(any())).thenReturn(Long.valueOf(3));

        // then
        mockMvc.perform(post("/api/numberPunctuations").content(
                text))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value", is(3)));

        verify(textServiceMock, times(1)).getPunctuationsNumber(any());
        verifyNoMoreInteractions(textServiceMock);

    }


}
