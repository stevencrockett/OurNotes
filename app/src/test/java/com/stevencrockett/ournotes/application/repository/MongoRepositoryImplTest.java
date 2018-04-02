package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNote;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.stevencrockett.ournotes.testing.data.TestData.A_GROUP_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.A_MONGO_COLLECTION_NAME;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MongoRepositoryImplTest {

    @Mock
    private MongoTemplate mongoTemplate;
    @Mock
    private NoteToMongoNoteMapper noteToMongoNoteMapper;
    @Mock
    private Note note;
    @Mock
    private MongoNote mongoNote;

    private MongoRepositoryImpl underTest;

    @Before
    public void setUp() {
        underTest = new MongoRepositoryImpl(mongoTemplate, A_MONGO_COLLECTION_NAME, noteToMongoNoteMapper);

        when(noteToMongoNoteMapper.toMongoNote(A_GROUP_ID, note)).thenReturn(mongoNote);
    }

    @Test
    public void shouldSaveMappedNoteToCollection() {
        underTest.insert(A_GROUP_ID, note);

        mongoTemplate.save(mongoNote, A_MONGO_COLLECTION_NAME);
    }

}