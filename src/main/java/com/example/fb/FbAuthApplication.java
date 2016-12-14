package com.example.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.fb")
public class FbAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(FbAuthApplication.class, args);
  }
}
