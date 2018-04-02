package com.stevencrockett.ournotes.config.repository;

import com.stevencrockett.ournotes.application.repository.MongoRepository;
import com.stevencrockett.ournotes.application.repository.MongoRepositoryImpl;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNoteToNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import com.stevencrockett.ournotes.config.repository.persistence.NoteMapperConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

@Configuration
@Import({MongoConfig.class, NoteMapperConfig.class})
public class MongoRepositoryConfig {

    @Value("${mongoCollectionName:OurNotes}")
    private String mongoCollectionName;

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private NoteToMongoNoteMapper noteToMongoNoteMapper;
    @Resource
    private MongoNoteToNoteMapper mongoNoteToNoteMapper;

    @Bean
    public MongoRepository mongoRepository() {
        return new MongoRepositoryImpl(mongoTemplate, mongoCollectionName, noteToMongoNoteMapper, mongoNoteToNoteMapper);
    }

}
