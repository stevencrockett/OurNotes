package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.stevencrockett.ournotes.testing.assertions.MongoNoteAssert.assertThat;
import static com.stevencrockett.ournotes.testing.data.TestData.A_GROUP_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.A_MONGO_DOCUMENT_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.NOTE_CONTENT;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteToMongoNoteMapperImplTest {

    @Mock
    private Note note;

    private NoteToMongoNoteMapperImpl underTest;

    @Before
    public void setUp() {
        underTest = new NoteToMongoNoteMapperImpl();

        when(note.getId()).thenReturn(Optional.of(A_MONGO_DOCUMENT_ID));
        when(note.getContent()).thenReturn(NOTE_CONTENT);
    }

    @Test
    public void shouldMapNoteToMongoNoteCorrectly() {
        MongoNote expected = new MongoNote();
        expected.setId(A_MONGO_DOCUMENT_ID);
        expected.setGroupId(A_GROUP_ID);
        expected.setContent(NOTE_CONTENT);

        MongoNote actual = underTest.toMongoNote(A_GROUP_ID, note);

        assertThat(actual).isEqualTo(expected);
    }


}