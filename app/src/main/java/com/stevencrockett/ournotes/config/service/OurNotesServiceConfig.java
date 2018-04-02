package com.stevencrockett.ournotes.config.service;

import com.stevencrockett.ournotes.application.repository.MongoRepository;
import com.stevencrockett.ournotes.application.service.OurNotesService;
import com.stevencrockett.ournotes.application.service.OurNotesServiceImpl;
import com.stevencrockett.ournotes.config.repository.MongoRepositoryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
@Import({MongoRepositoryConfig.class})
public class OurNotesServiceConfig {

    @Resource
    private MongoRepository mongoRepository;

    @Bean
    public OurNotesService ourNotesService() {
        return new OurNotesServiceImpl(mongoRepository);
    }

}
