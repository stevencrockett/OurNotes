package com.stevencrockett.ournotes.api;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Optional;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Note {

    private final String id;
    private final String content;

    public Note(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public Note(String content) {
        this(null, content);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, SHORT_PREFIX_STYLE);
    }

}
