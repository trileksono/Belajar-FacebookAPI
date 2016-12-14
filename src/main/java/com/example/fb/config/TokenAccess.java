/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.config;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;

/**
 * @author tri
 */
public class TokenAccess {
  private final String AppId = "333328447050598";
  private final String Key = "9ad06a113a943c3b314a11355e410ead";
  private AccessToken mToken;
  public FacebookClient facebookClient;
  public String accessToken;

  public TokenAccess(String shortToken) {
    FacebookClient client = new DefaultFacebookClient(shortToken);
    this.mToken = client.obtainExtendedAccessToken(AppId, Key);
    this.accessToken = mToken.getAccessToken();
    this.facebookClient = new DefaultFacebookClient(this.mToken.getAccessToken());

  }

  public String getAccessToken() {
    return accessToken;
  }

  public FacebookClient getFacebookClient() {
    return facebookClient;
  }
}
