package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.Comment;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.CommentRepo;
import com.sunitcb.classroom.service.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final ResponseModel responseModel;

    @Autowired
    CommentServiceImpl(CommentRepo commentRepo, ResponseModel responseModel) {
        this.commentRepo = commentRepo;
        this.responseModel = responseModel;
    }

    @Override
    public ResponseModel getAllComments() {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(commentRepo.findAll());
        return responseModel;
    }

    @Override
    public ResponseModel addCommentToPost(Comment comment) {
        commentRepo.save(comment);
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setMessage("Comment has been added to the post.");
        return responseModel;
    }
}
