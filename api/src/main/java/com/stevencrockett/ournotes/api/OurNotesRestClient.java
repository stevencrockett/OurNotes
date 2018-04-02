package com.stevencrockett.ournotes.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/ournotes/api/v1")
public interface OurNotesRestClient {

    @GetMapping(value = "/hello-world")
    @ResponseBody
    String helloWorld();

    @PostMapping(value = "/notes")
    @ResponseBody
    void createNote(CreateNote command);

    @GetMapping(value = "/groups/{}/notes")
    @ResponseBody
    Collection<Note> getNotesForGroup(@PathVariable String groupId);

}
