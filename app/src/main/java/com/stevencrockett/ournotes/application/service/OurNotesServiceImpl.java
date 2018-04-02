package com.stevencrockett.ournotes.application.service;

import com.stevencrockett.ournotes.api.CreateNote;
import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.MongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurNotesServiceImpl implements OurNotesService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MongoRepository mongoRepository;

    public OurNotesServiceImpl(MongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public String helloWorld() {
        return "Hello, world!";
    }

    @Override
    public void createNote(CreateNote command) {
        // TODO: dispatch to a dedicated command processor?
        Note note = new Note(command.getContent());
        log.info("Created note from command: {}", note);
        mongoRepository.insert(command.getGroupId(), note);
    }

}
