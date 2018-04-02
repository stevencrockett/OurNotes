package com.stevencrockett.ournotes.application.repository;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNote;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNoteToNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collection;
import java.util.Collections;

import static com.stevencrockett.ournotes.testing.data.TestData.A_GROUP_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.A_MONGO_COLLECTION_NAME;
import static com.stevencrockett.ournotes.testing.data.TestData.A_MONGO_DOCUMENT_ID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MongoRepositoryImplTest {

    @Mock
    private MongoTemplate mongoTemplate;
    @Mock
    private NoteToMongoNoteMapper noteToMongoNoteMapper;
    @Mock
    private MongoNoteToNoteMapper mongoNoteToNoteMapper;
    @Mock
    private Note note;
    @Mock
    private MongoNote mongoNote;

    private MongoRepositoryImpl underTest;

    @Before
    public void setUp() {
        underTest = new MongoRepositoryImpl(mongoTemplate, A_MONGO_COLLECTION_NAME, noteToMongoNoteMapper, mongoNoteToNoteMapper);

        when(noteToMongoNoteMapper.toMongoNote(A_GROUP_ID, note)).thenReturn(mongoNote);
    }

    @Test
    public void shouldSaveMappedNoteToCollection() {
        underTest.insert(A_GROUP_ID, note);

        mongoTemplate.save(mongoNote, A_MONGO_COLLECTION_NAME);
    }

    @Test
    public void shouldQueryDBUsingGroupIdAndMapBackToNotes() {
        Query expectedQuery = new Query(Criteria.where("groupId").is(A_GROUP_ID));

        when(mongoTemplate.find(expectedQuery, MongoNote.class, A_MONGO_COLLECTION_NAME))
                .thenReturn(Collections.singletonList(mongoNote));
        when(mongoNoteToNoteMapper.apply(mongoNote)).thenReturn(note);

        Collection<Note> expected = Collections.singletonList(note);

        Collection<Note> actual = underTest.retrieve(A_GROUP_ID);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldDeleteNoteByDocumentId() {
        Query expectedQuery = new Query(Criteria.where("_id").is(A_MONGO_DOCUMENT_ID));

        underTest.delete(A_MONGO_DOCUMENT_ID);

        verify(mongoTemplate).remove(expectedQuery, A_MONGO_COLLECTION_NAME);
    }

}