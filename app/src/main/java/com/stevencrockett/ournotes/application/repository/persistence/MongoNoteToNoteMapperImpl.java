package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;

public class MongoNoteToNoteMapperImpl implements MongoNoteToNoteMapper {

    @Override
    public Note toNote(MongoNote mongoNote) {
        return new Note(mongoNote.getId(), mongoNote.getContent());
    }

}
