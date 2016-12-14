/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.Controller;

import com.example.fb.entity.Group;
import com.example.fb.entity.Status;
import com.example.fb.repository.CommentRepository;
import com.example.fb.repository.GroupRepository;
import com.example.fb.repository.KamusRepository;
import com.example.fb.repository.SingkatanRepository;
import com.example.fb.repository.StatusRepository;
import com.example.fb.repository.StopWordRepository;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tri
 */
@RestController
public class CrawlController {
  @Autowired
  GroupRepository rGroup;

  @Autowired
  KamusRepository rKamus;

  @Autowired
  SingkatanRepository rSingkatan;

  @Autowired
  StatusRepository rStatus;

  @Autowired
  StopWordRepository rStopWord;

  @RequestMapping(value = "/crawl", method = RequestMethod.GET)
  private ResponseEntity crawl(
        @RequestParam("id") String id,
        @RequestParam("nama") String nama,
        HttpServletRequest request) {

    Group eGroup = new Group();
    eGroup.setId(id);
    eGroup.setNama(nama);
    rGroup.save(eGroup);
    int counter = 0;
    FacebookClient client = new DefaultFacebookClient(request.getSession().getAttribute("a").toString());
    Connection<Post> feed = client.fetchConnection(id + "/feed", Post.class);
    for (List<Post> lPost : feed) {
      for (Post post : lPost) {
        Comment user = client.fetchObject(post.getId(), Comment.class, Parameter.with("fields", "from"));
        Status status = new Status();
        status.setId(post.getId());
        status.setIdParent("0");
        status.setIdGroup(eGroup.getId());
        status.setMessage(post.getMessage());
        status.setIdUser(user.getFrom().getId());
        status.setNamaUser(user.getFrom().getName());
        status.setCreateDate(post.getUpdatedTime());

        rStatus.save(status);

        Connection<Comment> comments = client.fetchConnection(post.getId() + "/comments", Comment.class);
        List lComment = new ArrayList();
        for (List<Comment> lc : comments) {
          for (Comment cm : lc) {
           Status comment = new Status();
            comment.setId(cm.getId());
            comment.setIdGroup(eGroup.getId());
            comment.setMessage(cm.getMessage());
            comment.setIdParent(status.getId());
            comment.setCreateDate(cm.getCreatedTime());
            comment.setIdUser(cm.getFrom().getId());
            comment.setNamaUser(cm.getFrom().getName());

            rStatus.save(comment);
          }
        }

      }
    }
    return new ResponseEntity(rStatus.findAll(), HttpStatus.CREATED);
  }

  @RequestMapping(path = "/group/status/{page}", method = RequestMethod.GET)
  private ResponseEntity getGroup(@PathVariable("page") int page) {
    return new ResponseEntity(rStatus.findAll(new PageRequest(page, 25)), HttpStatus.OK);
  }
}
