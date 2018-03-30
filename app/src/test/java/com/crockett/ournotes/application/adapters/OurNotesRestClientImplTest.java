package com.crockett.ournotes.application.adapters;

import com.crockett.ournotes.application.service.OurNotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

}