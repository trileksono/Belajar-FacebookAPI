package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by TI04 on 12/8/2016.
 */
public class Training {
  @Id
  private String id;
  private String kata;
  private String sentimen;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKata() {
    return kata;
  }

  public void setKata(String kata) {
    this.kata = kata;
  }

  public String getSentimen() {
    return sentimen;
  }

  public void setSentimen(String sentimen) {
    this.sentimen = sentimen;
  }
}
