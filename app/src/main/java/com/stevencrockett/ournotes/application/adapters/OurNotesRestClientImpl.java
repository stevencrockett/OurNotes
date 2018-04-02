package com.stevencrockett.ournotes.application.adapters;

import com.stevencrockett.ournotes.api.CreateNote;
import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.api.OurNotesRestClient;
import com.stevencrockett.ournotes.application.service.OurNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public class OurNotesRestClientImpl implements OurNotesRestClient {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OurNotesService ourNotesService;

    public OurNotesRestClientImpl(OurNotesService ourNotesService) {
        this.ourNotesService = ourNotesService;
    }

    @Override
    public String helloWorld() {
        log.info("Received hello world request");
        return ourNotesService.helloWorld();
    }

    @Override
    public void createNote(CreateNote command) {
        log.info("Received create note command: {}", command);
        ourNotesService.createNote(command);
    }

    @Override
    public Collection<Note> getNotesForGroup(@PathVariable String groupId) {
        log.info("Querying notes for group: [{}]", groupId);
        return ourNotesService.getNotesForGroup(groupId);
    }

    @Override
    public void deleteNote(@PathVariable String noteId) {
        log.info("Deleting note with id: [{}]", noteId);
        ourNotesService.deleteNote(noteId);
    }

}
