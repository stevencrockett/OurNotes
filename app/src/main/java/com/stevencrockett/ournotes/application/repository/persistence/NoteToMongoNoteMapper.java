package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface NoteToMongoNoteMapper extends BiFunction<String, Note, MongoNote> {

    MongoNote toMongoNote(String groupId, Note note);

    @Override
    default MongoNote apply(String groupId, Note note) {
        return toMongoNote(groupId, note);
    }

}
