package com.stevencrockett.ournotes.config.service;

import com.stevencrockett.ournotes.application.service.OurNotesService;
import com.stevencrockett.ournotes.application.service.OurNotesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OurNotesServiceConfig {

    @Bean
    public OurNotesService ourNotesService() {
        return new OurNotesServiceImpl();
    }

}
