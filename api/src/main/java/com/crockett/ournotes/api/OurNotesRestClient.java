package com.crockett.ournotes.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/ournotes/api/v1")
public interface OurNotesRestClient {

    @GetMapping(value = "/hello-world")
    @ResponseBody
    String helloWorld();

}
