/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.repository;

import com.example.fb.entity.StopWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author tri
 */
public interface StopWordRepository extends MongoRepository<StopWord, String> {

  @Query("{kataStop : ?0}")
  public StopWord findStopWordByKataStop(String kata);
}
