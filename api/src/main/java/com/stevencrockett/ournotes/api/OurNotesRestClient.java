package com.stevencrockett.ournotes.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/ournotes/api/v1")
public interface OurNotesRestClient {

    @GetMapping(value = "/hello-world")
    @ResponseBody
    String helloWorld();

    @PostMapping(value = "/notes")
    void createNote(CreateNote command);

}
