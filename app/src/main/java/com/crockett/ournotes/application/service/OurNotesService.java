package com.crockett.ournotes.application.service;

import com.crockett.ournotes.api.CreateNote;

public interface OurNotesService {

    String helloWorld();

    void createNote(CreateNote command);

}
