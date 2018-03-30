package com.stevencrockett.ournotes.application.service;

import com.stevencrockett.ournotes.api.CreateNote;

public interface OurNotesService {

    String helloWorld();

    void createNote(CreateNote command);

}
