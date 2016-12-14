package com.example.fb.model;

/**
 * Created by tri on 11/30/16.
 */
public class LoginResponse {

  AuthResponse authResponse;
  String status;

  public AuthResponse getAuthResponse() {
    return authResponse;
  }

  public void setAuthResponse(AuthResponse authResponse) {
    this.authResponse = authResponse;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public class AuthResponse {
    String accessToken;
    double expiresIn;
    String signedRequest;
    String userID;

    public String getAccessToken() {
      return accessToken;
    }

    public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
    }

    public double getExpiresIn() {
      return expiresIn;
    }

    public void setExpiresIn(double expiresIn) {
      this.expiresIn = expiresIn;
    }

    public String getSignedRequest() {
      return signedRequest;
    }

    public void setSignedRequest(String signedRequest) {
      this.signedRequest = signedRequest;
    }

    public String getUserID() {
      return userID;
    }

    public void setUserID(String userID) {
      this.userID = userID;
    }
  }
}
