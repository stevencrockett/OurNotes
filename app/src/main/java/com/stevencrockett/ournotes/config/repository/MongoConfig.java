package com.stevencrockett.ournotes.config.repository;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import javax.annotation.Resource;


@Configuration
@Import({MongoClientEmbeddedConfig.class})
public class MongoConfig extends AbstractMongoConfiguration {

    @Resource
    private MongoClient mongoClient;

    @Override
    public MongoClient mongoClient() {
        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return "OurNotes";
    }

}
