/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fb.Controller;

import com.example.fb.entity.Member;
import com.example.fb.entity.Training;
import com.example.fb.repository.MemberRepository;
import com.example.fb.repository.StatusRepository;
import com.example.fb.repository.TrainingRepository;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author tri
 */
@RestController
public class GroupController {

  @Autowired
  MemberRepository rMember;

  @Autowired
  StatusRepository rStatus;

  @Autowired
  TrainingRepository rTraining;

  @RequestMapping(path = "/group/{keyword}", method = RequestMethod.GET)
  private ResponseEntity getGroup(@PathVariable("keyword") String keyword, HttpServletRequest request) {
    try {
      FacebookClient client = new DefaultFacebookClient(request.getSession().getAttribute("a").toString());
      Connection<Group> publicSearch1
            = client.fetchConnection("search", Group.class, Parameter.with("q", keyword),
            Parameter.with("limit", 50),
            Parameter.with("type", "group"));
      HashMap map = new HashMap();
      map.put("data", publicSearch1.getData());
      return new ResponseEntity(map, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(path = "/group/id/{id}", method = RequestMethod.GET)
  private ResponseEntity getPostGroup(
        @PathVariable("id") String id,
        HttpServletRequest request) {

    try {
      FacebookClient client = new DefaultFacebookClient(request.getSession().getAttribute("a").toString());
      Connection<Post> feed = client.fetchConnection(id + "/feed", Post.class);
      List<HashMap> data = new ArrayList<>();
      for (List<Post> lPost : feed) {
        for (Post post : lPost) {
          Comment user = client.fetchObject(post.getId(), Comment.class, Parameter.with("fields", "from"));
          HashMap mUser = new HashMap();
          mUser.put("id", user.getFrom().getId());
          mUser.put("name", user.getFrom().getName());

          Connection<Comment> comments = client.fetchConnection(post.getId() + "/comments", Comment.class);
          List lComment = new ArrayList();
          for (List<Comment> lc : comments) {
            for (Comment cm : lc) {
              HashMap mComment = new HashMap();
              mComment.put("id_comment", cm.getId());
              mComment.put("message", cm.getMessage());
              mComment.put("from", cm.getFrom());
              lComment.add(mComment);
            }
          }
          HashMap map = new HashMap();
          map.put("id_post", post.getId());
          map.put("message", post.getMessage());
          map.put("from", mUser);
          map.put("comment", lComment);
          data.add(map);
        }
        if (data.size() >= 50) {
          break;
        }
      }
      HashMap map = new HashMap();
      map.put("data", data);
      return new ResponseEntity(map, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(path = "/group/{id}/members")
  private ResponseEntity getMembersGroup(
        @PathVariable("id") String id,
        HttpServletRequest request) {
    try {
      FacebookClient client = new DefaultFacebookClient(request.getSession().getAttribute("a").toString());
      Connection<User> publicSearch1
            = client.fetchConnection(id + "/members", User.class, Parameter.with("field", "name"));
      List<Member> listMember = new ArrayList<>();
      for (List<User> lu : publicSearch1) {
        for (User user : lu) {
          Member member = new Member();
          member.setId(user.getId());
          member.setName(user.getName().toLowerCase());
          listMember.add(member);
        }
      }
      rMember.save(listMember);
      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(path = "/group/member")
  private ResponseEntity getMemberLike(
        @RequestParam("name") String name,
        HttpServletRequest request) {
    List data = new ArrayList<>();
    data = rMember.findByNameLike(name);
    HashMap map = new HashMap();
    map.put("results",data);
    return new ResponseEntity(data, HttpStatus.OK);
  }

  @RequestMapping(path = "/training/insert", method = RequestMethod.POST)
  private ResponseEntity insertTraining(@RequestBody Training[] trains){
    rTraining.save(Arrays.asList(trains));
    return new ResponseEntity(rTraining.findTraining(trains[0].getSentimen()),HttpStatus.OK);
  }
}
