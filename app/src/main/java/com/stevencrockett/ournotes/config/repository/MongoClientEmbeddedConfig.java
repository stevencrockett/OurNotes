package com.stevencrockett.ournotes.config.repository;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MongoClientEmbeddedConfig {

    @Bean
    public MongoClient mongoClient() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp("127.0.0.1");
        mongo.setPort(27017);
        return mongo.getObject();
    }

}
