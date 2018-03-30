package com.stevencrockett.ournotes.application.adapters;

import com.stevencrockett.ournotes.application.service.OurNotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.stevencrockett.ournotes.testing.data.TestData.A_CREATE_NOTE_COMMAND;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OurNotesRestClientImplTest {

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