package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNote;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNoteToNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MongoRepositoryImpl implements MongoRepository {

    private final MongoTemplate mongoTemplate;
    private final String mongoCollectionName;
    private final NoteToMongoNoteMapper noteToMongoNoteMapper;
    private final MongoNoteToNoteMapper mongoNoteToNoteMapper;

    public MongoRepositoryImpl(MongoTemplate mongoTemplate,
                               String mongoCollectionName,
                               NoteToMongoNoteMapper noteToMongoNoteMapper,
                               MongoNoteToNoteMapper mongoNoteToNoteMapper) {
        this.mongoTemplate = mongoTemplate;
        this.mongoCollectionName = mongoCollectionName;
        this.noteToMongoNoteMapper = noteToMongoNoteMapper;
        this.mongoNoteToNoteMapper = mongoNoteToNoteMapper;
    }

    @Override
    public void insert(String groupId, Note note) {
        MongoNote mongoNote = noteToMongoNoteMapper.toMongoNote(groupId, note);
        mongoTemplate.insert(mongoNote, mongoCollectionName);
    }

    @Override
    public Collection<Note> retrieve(String groupId) {
        Query query = new Query(Criteria.where("groupId").is(groupId));

        List<MongoNote> storedMongoNotes = mongoTemplate.find(query, MongoNote.class, mongoCollectionName);
        List<Note> notes = storedMongoNotes.stream()
                .map(mongoNoteToNoteMapper)
                .collect(toList());

        return notes;
    }

    @Override
    public void delete(String noteId) {
        Query query = new Query(Criteria.where("_id").is(noteId));
        mongoTemplate.remove(query, mongoCollectionName);
    }

}
