package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNote;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoRepositoryImpl implements MongoRepository {

    private final MongoTemplate mongoTemplate;
    private final String mongoCollectionName;
    private final NoteToMongoNoteMapper noteToMongoNoteMapper;

    public MongoRepositoryImpl(MongoTemplate mongoTemplate,
                               String mongoCollectionName,
                               NoteToMongoNoteMapper noteToMongoNoteMapper) {
        this.mongoTemplate = mongoTemplate;
        this.mongoCollectionName = mongoCollectionName;
        this.noteToMongoNoteMapper = noteToMongoNoteMapper;
    }

    @Override
    public void insert(String groupId, Note note) {
        MongoNote mongoNote = noteToMongoNoteMapper.toMongoNote(groupId, note);
        mongoTemplate.insert(mongoNote, mongoCollectionName);
    }

}
