package com.crockett.ournotes.application.service;

import com.crockett.ournotes.api.CreateNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurNotesServiceImpl implements OurNotesService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String helloWorld() {
        return "Hello, world!";
    }

    @Override
    public void createNote(CreateNote command) {
        // TODO: process command
    }

}
