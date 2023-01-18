package com.sunitcb.classroom.controller;

import com.sunitcb.classroom.domain.Post;
import com.sunitcb.classroom.domain.dto.PostDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value="/posts", headers = "X-API-VERSION=v1")
    public ResponseEntity<ResponseModel> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAll());
    }

    @GetMapping(value="/posts", headers = "X-API-VERSION=v2")
    public ResponseEntity<ResponseModel> getAllOrWithAuthors(@RequestParam(required = false) String srcAuthor) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllOrWithAuthor(srcAuthor));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<ResponseModel> getPost(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
    }

    @PostMapping("/posts")
    public ResponseEntity<ResponseModel> savePost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.save(post));
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<ResponseModel> updatePost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.update(post));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ResponseModel> deletePost(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.delete(id));
    }

}
