/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * @author tri
 */
@Configuration
public class MongoConf extends AbstractMongoConfiguration {

  @Override
  protected String getDatabaseName() {
    return "db_sentiment";
  }

  @Override
  public Mongo mongo() throws Exception {
    return new Mongo("127.0.0.1");
  }

}
