/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.repository;

import com.example.fb.entity.Comment;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author tri
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

  public List<Comment> findCommentByidParent(String idParent);

}
