package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by tri on 12/1/16.
 */
public class StopWord {

  @Id
  private String id;
  private String kataStop;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKataStop() {
    return kataStop;
  }

  public void setKataStop(String kataStop) {
    this.kataStop = kataStop;
  }
}
