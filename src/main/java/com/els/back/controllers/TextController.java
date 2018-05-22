package com.els.back.controllers;

import com.els.back.services.TextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TextController {

    @Autowired
    private TextService textService;

    private final Logger log = LoggerFactory.getLogger(TextController.class);

    /**
     * Returns the the number of punctuations inside a given text
     * @return
     */
    @RequestMapping(value = "/numberPunctuations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPunctuations(@RequestBody String message) {

        long numberOfPunctuations = textService.getPunctuationsNumber(message);

        return new ResponseEntity<>("{\"value\":" + String.valueOf(numberOfPunctuations) + "}", HttpStatus.OK);
    }


}
