package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;

public interface MongoRepository {

    void insert(String groupId, Note note);

}
