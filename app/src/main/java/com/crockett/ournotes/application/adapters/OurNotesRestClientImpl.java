package com.crockett.ournotes.application.adapters;

import com.crockett.ournotes.api.OurNotesRestClient;
import com.crockett.ournotes.application.service.OurNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurNotesRestClientImpl implements OurNotesRestClient {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OurNotesService ourNotesService;

    public OurNotesRestClientImpl(OurNotesService ourNotesService) {
        this.ourNotesService = ourNotesService;
    }

    @Override
    public String helloWorld() {
        log.info("Received hello world request");
        return ourNotesService.helloWorld();
    }

}
