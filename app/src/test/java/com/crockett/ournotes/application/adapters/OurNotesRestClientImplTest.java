package com.crockett.ournotes.application.adapters;

import com.crockett.ournotes.api.CreateNote;
import com.crockett.ournotes.application.service.OurNotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OurNotesRestClientImplTest {

    private static final String A_GROUP_ID = "GROUP_ID";
    private static final String SOME_CONTENT = "NOTE_CONTENT";
    private static final CreateNote A_CREATE_NOTE_COMMAND = new CreateNote(A_GROUP_ID, SOME_CONTENT);

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

}