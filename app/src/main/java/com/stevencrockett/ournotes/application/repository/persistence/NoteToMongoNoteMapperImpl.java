package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;

public class NoteToMongoNoteMapperImpl implements NoteToMongoNoteMapper {

    @Override
    public MongoNote toMongoNote(String groupId, Note note) {
        MongoNote mongoNote = new MongoNote();
        mongoNote.setGroupId(groupId);
        mongoNote.setContent(note.getContent());
        note.getId().ifPresent(mongoNote::setId);
        return mongoNote;
    }

}
