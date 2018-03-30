package com.crockett.ournotes.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurNotesServiceImpl implements OurNotesService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String helloWorld() {
        return "Hello, world!";
    }

}
