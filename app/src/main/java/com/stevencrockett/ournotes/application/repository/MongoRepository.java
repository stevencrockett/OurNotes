package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;

import java.util.Collection;

public interface MongoRepository {

    void insert(String groupId, Note note);

    Collection<Note> retrieve(String groupId);

    void delete(String noteId);

}
