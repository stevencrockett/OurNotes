package com.stevencrockett.ournotes.config.repository.persistence;

import com.stevencrockett.ournotes.application.repository.persistence.MongoNoteToNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.MongoNoteToNoteMapperImpl;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteMapperConfig {

    @Bean
    public NoteToMongoNoteMapper noteToMongoNoteMapper() {
        return new NoteToMongoNoteMapperImpl();
    }

    @Bean
    public MongoNoteToNoteMapper mongoNoteToNoteMapper() {
        return new MongoNoteToNoteMapperImpl();
    }

}
