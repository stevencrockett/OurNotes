package com.stevencrockett.ournotes.config.repository.persistence;

import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapper;
import com.stevencrockett.ournotes.application.repository.persistence.NoteToMongoNoteMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoteMapperConfig {

    @Bean
    NoteToMongoNoteMapper noteToMongoNoteMapper() {
        return new NoteToMongoNoteMapperImpl();
    }

}
