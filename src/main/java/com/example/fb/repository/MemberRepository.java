package com.example.fb.repository;

import com.example.fb.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by tri on 12/5/16.
 */
public interface MemberRepository extends MongoRepository<Member, String> {

  public List<Member> findByNameLike(String name);

}
