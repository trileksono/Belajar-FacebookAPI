package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by tri on 12/1/16.
 */
public class Singkatan {

  @Id
  private String id;
  private String kataSingkatan;
  private String kataAsli;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKataSingkatan() {
    return kataSingkatan;
  }

  public void setKataSingkatan(String kataSingkatan) {
    this.kataSingkatan = kataSingkatan;
  }

  public String getKataAsli() {
    return kataAsli;
  }

  public void setKataAsli(String kataAsli) {
    this.kataAsli = kataAsli;
  }
}
