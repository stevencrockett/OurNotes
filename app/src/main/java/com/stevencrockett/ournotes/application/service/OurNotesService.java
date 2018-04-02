package com.stevencrockett.ournotes.application.service;

import com.stevencrockett.ournotes.api.CreateNote;
import com.stevencrockett.ournotes.api.Note;

import java.util.Collection;

public interface OurNotesService {

    String helloWorld();

    void createNote(CreateNote command);

    Collection<Note> getNotesForGroup(String groupId);

}
