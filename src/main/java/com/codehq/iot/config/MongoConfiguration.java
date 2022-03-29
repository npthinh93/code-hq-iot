package com.codehq.iot.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.codehq.iot.repository")
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    private final MongoProperties mongoProperties;

    public MongoConfiguration(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return mongoProperties.getDatabase();
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}
