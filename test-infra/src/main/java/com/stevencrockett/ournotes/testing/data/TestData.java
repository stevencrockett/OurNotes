package com.stevencrockett.ournotes.testing.data;

import com.stevencrockett.ournotes.api.CreateNote;
import com.stevencrockett.ournotes.api.Note;

public class TestData {

    public static final String A_MONGO_DOCUMENT_ID = "5ac17292c573be080d44063f";
    public static final String A_MONGO_COLLECTION_NAME = "Collection";

    public static final String A_GROUP_ID = "GROUP_ID";
    public static final String NOTE_CONTENT = "WRITE STUFF HERE";

    public static final CreateNote A_CREATE_NOTE_COMMAND = new CreateNote(A_GROUP_ID, NOTE_CONTENT);

    public static final Note A_NOTE = new Note(A_MONGO_DOCUMENT_ID, NOTE_CONTENT);

}
