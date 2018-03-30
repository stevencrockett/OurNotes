package com.stevencrockett.ournotes.api;

public class CreateNote {

    private final String groupId;
    private final String content;

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

}
