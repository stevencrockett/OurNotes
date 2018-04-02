package com.stevencrockett.ournotes.testing.assertions;

import com.stevencrockett.ournotes.application.repository.persistence.MongoNote;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class MongoNoteAssert extends AbstractAssert<MongoNoteAssert, MongoNote> {

    public MongoNoteAssert(MongoNote actual) {
        super(actual, MongoNoteAssert.class);
    }

    public static MongoNoteAssert assertThat(MongoNote actual) {
        return new MongoNoteAssert(actual);
    }

    public MongoNoteAssert isEqualTo(MongoNote expected) {
        isNotNull();

        if (Objects.isNull(expected)) {
            failWithMessage("Expected a MongoNote, but was null");
        }

        if (!Objects.equals(actual.getId(), expected.getId())) {
            failWithMessage("Expected id to be <%s> but was <%s>", expected.getId(), actual.getId());
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
