package com.stevencrockett.ournotes.application.service;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.repository.MongoRepository;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;

import static com.stevencrockett.ournotes.testing.assertions.NoteAssert.assertThat;
import static com.stevencrockett.ournotes.testing.data.TestData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

@RunWith(MockitoJUnitRunner.class)
public class OurNotesServiceImplTest {

    @Mock
    private Collection<Note> someNotes;
    @Mock
    private MongoRepository mongoRepository;

    private OurNotesServiceImpl underTest;

    @Before
    public void setUp() {
        underTest = new OurNotesServiceImpl(mongoRepository);

        when(mongoRepository.retrieve(A_GROUP_ID)).thenReturn(someNotes);
    }

    @Test
    public void shouldCreateNoteFromCommandAndInsertViaRepository() {
        underTest.createNote(A_CREATE_NOTE_COMMAND);

        Note expectedNote = new Note(NOTE_CONTENT);

        verify(mongoRepository).insert(eq(A_GROUP_ID), argThat(new AssertionMatcher<Note>() {

            @Override
            public void assertion(Note actual) throws AssertionError {
                assertThat(actual).isEqualTo(expectedNote);
            }

        }));

    }

    @Test
    public void shouldQueryNotesViaRepository() {
        Collection<Note> actual = underTest.getNotesForGroup(A_GROUP_ID);
        assertThat(actual).isEqualTo(someNotes);
    }

}