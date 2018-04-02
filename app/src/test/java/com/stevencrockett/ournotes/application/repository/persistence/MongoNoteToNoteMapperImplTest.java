package com.stevencrockett.ournotes.application.repository.persistence;

import com.stevencrockett.ournotes.api.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.stevencrockett.ournotes.testing.assertions.NoteAssert.assertThat;
import static com.stevencrockett.ournotes.testing.data.TestData.A_MONGO_DOCUMENT_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.NOTE_CONTENT;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MongoNoteToNoteMapperImplTest {

    @Mock
    private MongoNote mongoNote;

    private MongoNoteToNoteMapperImpl underTest;

    @Before
    public void setUp() {
        underTest = new MongoNoteToNoteMapperImpl();

        when(mongoNote.getId()).thenReturn(A_MONGO_DOCUMENT_ID);
        when(mongoNote.getContent()).thenReturn(NOTE_CONTENT);
    }

    @Test
    public void shouldMapMongoNoteToNoteCorrectly() {
        Note expected = new Note(A_MONGO_DOCUMENT_ID, NOTE_CONTENT);

        Note actual = underTest.toNote(mongoNote);

        assertThat(actual).isEqualTo(expected);
    }

}