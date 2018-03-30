package com.stevencrockett.ournotes.testing.assertions;

import com.stevencrockett.ournotes.api.CreateNote;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class CreateNoteAssert extends AbstractAssert<CreateNoteAssert, CreateNote> {

    public CreateNoteAssert(CreateNote actual) {
        super(actual, CreateNoteAssert.class);
    }

    public static CreateNoteAssert assertThat(CreateNote actual) {
        return new CreateNoteAssert(actual);
    }

    public CreateNoteAssert isEqualTo(CreateNote expected) {
        isNotNull();

        if (Objects.isNull(expected)) {
            failWithMessage("Expected a CreateNote command, but was null");
        }

        if (!Objects.equals(actual.getGroupId(), expected.getGroupId())) {
            failWithMessage("Expected groupId to be <%s> but was <%s>", expected.getGroupId(), actual.getGroupId());
        }

        if (!Objects.equals(actual.getContent(), expected.getContent())) {
            failWithMessage("Expected content to be <%s> but was <%s>", expected.getContent(), actual.getContent());
        }

        return this;
    }

}
