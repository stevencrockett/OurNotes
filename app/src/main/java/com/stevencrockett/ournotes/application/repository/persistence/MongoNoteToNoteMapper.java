package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;

import java.util.function.Function;

public interface MongoNoteToNoteMapper extends Function<MongoNote, Note> {

    Note toNote(MongoNote mongoNote);


    @Override
    default Note apply(MongoNote mongoNote) {
        return toNote(mongoNote);
    }
}
