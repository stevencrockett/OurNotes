package com.stevencrockett.ournotes.testing.assertions;

import com.stevencrockett.ournotes.api.Note;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class NoteAssert extends AbstractAssert<NoteAssert, Note> {

    public NoteAssert(Note actual) {
        super(actual, NoteAssert.class);
    }

    public static NoteAssert assertThat(Note actual) {
        return new NoteAssert(actual);
    }

    public NoteAssert isEqualTo(Note expected) {
        isNotNull();

        if (Objects.isNull(expected)) {
            failWithMessage("Expected a Note, but was null");
        }

        if (!Objects.equals(actual.getId(), expected.getId())) {
            failWithMessage("Expected id to be <%s> but was <%s>", expected.getId(), actual.getId());
        }

        if (!Objects.equals(actual.getContent(), expected.getContent())) {
            failWithMessage("Expected content to be <%s> but was <%s>", expected.getContent(), actual.getContent());
        }

        return this;
    }

}
