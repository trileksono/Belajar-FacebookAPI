package com.example.fb.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by tri on 12/7/16.
 */
public class Sentiment {

  @Id
  private String id;
  private String idUser;
  private String idStatus;
  private double totalNegatif;
  private double totalPositif;
  private String sentimen;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getIdStatus() {
    return idStatus;
  }

  public void setIdStatus(String idStatus) {
    this.idStatus = idStatus;
  }

  public double getTotalNegatif() {
    return totalNegatif;
  }

  public void setTotalNegatif(double totalNegatif) {
    this.totalNegatif = totalNegatif;
  }

  public double getTotalPositif() {
    return totalPositif;
  }

  public void setTotalPositif(double totalPositif) {
    this.totalPositif = totalPositif;
  }

  public String getSentimen() {
    return sentimen;
  }

  public void setSentimen(String sentimen) {
    this.sentimen = sentimen;
  }
}
