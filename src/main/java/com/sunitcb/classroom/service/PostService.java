package com.sunitcb.classroom.service;

import com.sunitcb.classroom.domain.Post;
import com.sunitcb.classroom.domain.dto.PostDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.PostRepo;
import com.sunitcb.classroom.repo.impl.PostRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    ResponseModel getAll();
    ResponseModel getAllOrWithAuthor(String srcAuthor);
    ResponseModel findById(int id);
    ResponseModel save(Post post);
    ResponseModel update(Post post);
    ResponseModel delete(int id);

}
