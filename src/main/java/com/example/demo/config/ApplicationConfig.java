package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ApplicationConfig
{
    @Bean("mongoTransactionManager")
    MongoTransactionManager _transactionManager(MongoDatabaseFactory dbFactory)
    {
        return new MongoTransactionManager(dbFactory);
    }

    @Bean("jpaTransactionManager")
    JpaTransactionManager _jpaTransactionManager()
    {
        return new JpaTransactionManager();
    }

    @Bean("platformTransactionManager")
    PlatformTransactionManager _platformTransactionManager(@Autowired MongoTransactionManager mongoTransactionManager,
                                                           @Autowired JpaTransactionManager jpaTransactionManager)
    {
        ChainedTransactionManager chainedTransactionManager =
            new ChainedTransactionManager(mongoTransactionManager, jpaTransactionManager);
        return chainedTransactionManager;

    }
}
