package com.sunitcb.classroom.controller;

import com.sunitcb.classroom.domain.Comment;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> saveComment(@RequestBody Comment comment) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.addCommentToPost(comment));
    }

}
