package com.crockett.ournotes.config.service;

import com.crockett.ournotes.application.service.OurNotesService;
import com.crockett.ournotes.application.service.OurNotesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OurNotesServiceConfig {

    @Bean
    public OurNotesService ourNotesService() {
        return new OurNotesServiceImpl();
    }

}
