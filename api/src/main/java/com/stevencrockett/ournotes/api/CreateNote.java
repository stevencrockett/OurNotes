package com.stevencrockett.ournotes.api;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class CreateNote {

    private final String groupId;
    private final String content;

    private CreateNote() {
        this(null, null);
    }

    public CreateNote(String groupId, String content) {
        this.groupId = groupId;
        this.content = content;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, SHORT_PREFIX_STYLE);
    }

}
