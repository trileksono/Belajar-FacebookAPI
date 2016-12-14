/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.Controller;

import com.example.fb.entity.Singkatan;
import com.example.fb.entity.Status;
import com.example.fb.entity.StopWord;
import com.example.fb.entity.Training;
import com.example.fb.naive.BayesClassifier;
import com.example.fb.naive.Classifier;
import com.example.fb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tri
 */
@Controller
public class PageController {

  @Autowired
  StatusRepository rStatus;

  @Autowired
  CommentRepository rComment;

  @Autowired
  SingkatanRepository rSingkatan;

  @Autowired
  StopWordRepository rStopWord;

  @Autowired
  KamusRepository rKamus;

  @Autowired
  TrainingRepository rTraining;

  private Matcher m;
  private Pattern p;
  private StringTokenizer str;

  @RequestMapping(value = "page/{name}", method = RequestMethod.GET)
  public void redirect(@PathVariable("name") String name, Model m, HttpServletRequest request) {
  }

  @RequestMapping(value = "page/group_post/{page}", method = RequestMethod.GET)
  public ModelAndView getGroupPost(
        ModelAndView m,
        HttpServletRequest request,
        @PathVariable("page") int page) {
    m.addObject("list", rStatus.findStatusOnly(new PageRequest(page, 50)));
    m.setViewName("page/GroupPost");
    return m;
  }

  @RequestMapping(value = "page/post/{id}", method = RequestMethod.GET)
  public ModelAndView getPost(
        ModelAndView m,
        HttpServletRequest request,
        @PathVariable("id") String id) {
    Status sts = rStatus.findOne(id);
    m.addObject("post", sts);
    m.addObject("comment", rStatus.findStatusByIdParent(sts.getId()));
    m.setViewName("page/PostComment");
    return m;
  }

}
