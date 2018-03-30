package com.stevencrockett.ournotes.config.adapters;

import com.stevencrockett.ournotes.api.OurNotesRestClient;
import com.stevencrockett.ournotes.application.adapters.OurNotesRestClientImpl;
import com.stevencrockett.ournotes.application.service.OurNotesService;
import com.stevencrockett.ournotes.config.service.OurNotesServiceConfig;
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
