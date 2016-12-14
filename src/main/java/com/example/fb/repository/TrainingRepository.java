package com.example.fb.repository;

import com.example.fb.entity.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by TI04 on 12/8/2016.
 */
public interface TrainingRepository extends MongoRepository<Training,String> {

  @Query("{sentimen : ?0}")
  List<Training> findTraining(String sentimen);

}
