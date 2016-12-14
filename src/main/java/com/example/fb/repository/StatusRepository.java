/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.repository;

import com.example.fb.entity.Status;

import java.io.Serializable;
import java.util.List;

import com.restfb.types.PageLabel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author tri
 */
public interface StatusRepository extends MongoRepository<Status, String> {

  List<Status> findStatusByidGroup(String idGroup);

  @Query("{idParent : '0'}")
  List<Status> findStatusOnly(Pageable pageable);

  List<Status> findStatusByidUser(String idUser, Pageable pageable);

  List<Status> findStatusByIdParent(String idParent);
}
