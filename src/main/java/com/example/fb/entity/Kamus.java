package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by tri on 12/1/16.
 */
public class Kamus {

  @Id
  private String id;
  private String kata;
  private String jenis;

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

  public String getJenis() {
    return jenis;
  }

  public void setJenis(String jenis) {
    this.jenis = jenis;
  }
}
