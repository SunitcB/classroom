package com.sunitcb.classroom.service;

import com.sunitcb.classroom.domain.Comment;
import com.sunitcb.classroom.domain.dto.ResponseModel;

import java.util.List;

public interface CommentService {
    ResponseModel getAllComments();
    ResponseModel addCommentToPost(Comment comment);
}
