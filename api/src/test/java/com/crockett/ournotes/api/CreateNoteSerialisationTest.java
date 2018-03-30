package com.crockett.ournotes.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNoteSerialisationTest {

    private static final String A_GROUP_ID = "GROUP_ID";
    private static final String SOME_CONTENT = "NOTE_CONTENT";
    private static final CreateNote A_CREATE_NOTE_COMMAND = new CreateNote(A_GROUP_ID, SOME_CONTENT);

    private static final String EXPECTED_JSON = "{" +
            "\"groupId\":\"GROUP_ID\"," +
            "\"content\":\"NOTE_CONTENT\"" +
            "}";

    private JacksonTester<CreateNote> json;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void testWriteJson() throws IOException {
        String actual = json.write(A_CREATE_NOTE_COMMAND).getJson();
        assertThat(actual).isEqualTo(EXPECTED_JSON);
    }

}