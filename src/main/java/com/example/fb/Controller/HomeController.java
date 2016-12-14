package com.example.fb.Controller;

import com.example.fb.config.TokenAccess;
import com.example.fb.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by TI04 on 11/28/2016.
 */

@RestController
public class HomeController {

  @RequestMapping(value = "/home", method = RequestMethod.POST)
  public ResponseEntity resp(
        @RequestBody LoginResponse response, HttpServletRequest request) {
    if (response.getStatus().equals("connected")) {
      TokenAccess access = new TokenAccess(response.getAuthResponse().getAccessToken());
      request.getSession().setAttribute("a", access.accessToken);
    }
    return new ResponseEntity(HttpStatus.OK);
  }
}
