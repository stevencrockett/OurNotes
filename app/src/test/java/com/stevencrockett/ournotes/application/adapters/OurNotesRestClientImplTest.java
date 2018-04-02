package com.stevencrockett.ournotes.application.adapters;

import com.stevencrockett.ournotes.api.Note;
import com.stevencrockett.ournotes.application.service.OurNotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static com.stevencrockett.ournotes.testing.data.TestData.A_CREATE_NOTE_COMMAND;
import static com.stevencrockett.ournotes.testing.data.TestData.A_GROUP_ID;
import static com.stevencrockett.ournotes.testing.data.TestData.A_NOTE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OurNotesRestClientImplTest {

    private static final List<Note> SOME_NOTES = Collections.singletonList(A_NOTE);

    @Mock
    private OurNotesService ourNotesService;

    private OurNotesRestClientImpl underTest;

    @Before
    public void setUp() {
        underTest = new OurNotesRestClientImpl(ourNotesService);
    }

    @Test
    public void shouldDelegateHelloWorldToService() {
        underTest.helloWorld();

        verify(ourNotesService).helloWorld();
    }

    @Test
    public void shouldDelegateCreateNoteCommandToService() {
        underTest.createNote(A_CREATE_NOTE_COMMAND);

        verify(ourNotesService).createNote(A_CREATE_NOTE_COMMAND);
    }

    @Test
    public void shouldDelegateQueryingNotesToService() {
        when(ourNotesService.getNotesForGroup(A_GROUP_ID)).thenReturn(SOME_NOTES);

        Collection<Note> actual = underTest.getNotesForGroup(A_GROUP_ID);

        assertThat(actual).isEqualTo(SOME_NOTES);
    }

}