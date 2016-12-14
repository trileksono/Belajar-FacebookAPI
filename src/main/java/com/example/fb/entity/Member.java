package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by tri on 12/5/16.
 */
public class Member {

  @Id
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
