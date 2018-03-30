package com.crockett.ournotes.config.adapters;

import com.crockett.ournotes.api.OurNotesRestClient;
import com.crockett.ournotes.application.adapters.OurNotesRestClientImpl;
import com.crockett.ournotes.application.service.OurNotesService;
import com.crockett.ournotes.config.service.OurNotesServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
@Import({OurNotesServiceConfig.class})
public class OurNotesRestClientConfig {

    @Resource
    private OurNotesService ourNotesService;

    @Bean
    public OurNotesRestClient ourNotesRestClient() {
        return new OurNotesRestClientImpl(ourNotesService);
    }

}
