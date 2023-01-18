package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.Post;
import com.sunitcb.classroom.domain.dto.PostDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.PostRepo;
import com.sunitcb.classroom.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;
    private final ResponseModel responseModel;

    @Autowired
    PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, ResponseModel responseModel) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.responseModel = responseModel;
    }

    @Override
    public ResponseModel getAll() {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(postRepo.findAll().stream()
                .map(item -> modelMapper.map(item, PostDTO.class))
                .collect(Collectors.toList()));
        return responseModel;
    }

    @Override
    public ResponseModel getAllOrWithAuthor(String srcAuthor) {
        if (srcAuthor == null) {
            return getAll();
        } else {
            System.out.println("srcAuthor = " + srcAuthor);
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setData(postRepo.findAllByAuthor(srcAuthor));
            return responseModel;
        }
    }

    @Override
    public ResponseModel findById(int id) {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(modelMapper.map(postRepo.findById(id), PostDTO.class));
        return responseModel;
    }

    @Override
    public ResponseModel save(Post post) {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(postRepo.save(post));
        responseModel.setMessage("Post has been saved successfully.");
        return responseModel;
    }

    @Override
    public ResponseModel update(Post post) {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(postRepo.update(post));
        responseModel.setMessage("POST has been updated successfully.");
        return responseModel;
    }

    @Override
    public ResponseModel delete(int id) {
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(postRepo.delete(id));
        responseModel.setMessage("Post has been deleted successfully");
        return responseModel;
    }
}
