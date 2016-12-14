/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.repository;

import com.example.fb.entity.Group;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author tri
 */
public interface GroupRepository extends MongoRepository<Group, String> {

}
