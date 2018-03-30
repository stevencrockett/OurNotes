package com.crockett.ournotes.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteSerialisationTest {

    private static final String SOME_CONTENT = "NOTE_CONTENT";
    private static final Note A_NOTE = new Note(SOME_CONTENT);

    private static final String EXPECTED_JSON = "{" +
            "\"content\":\"NOTE_CONTENT\"" +
            "}";

    private JacksonTester<Note> json;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void testWriteJson() throws IOException {
        String actual = json.write(A_NOTE).getJson();
        assertThat(actual).isEqualTo(EXPECTED_JSON);
    }

}