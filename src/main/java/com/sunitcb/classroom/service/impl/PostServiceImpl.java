package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.annotation.ExecutionTime;
import com.sunitcb.classroom.domain.Post;
import com.sunitcb.classroom.domain.dto.PostDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.PostRepo;
import com.sunitcb.classroom.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
//        responseModel.setData(Stream.of(postRepo.findAll())
//                .map(item -> modelMapper.map(item, PostDTO.class))
//                .collect(Collectors.toList()));
        responseModel.setData(postRepo.findAll());
//        System.out.println("responseModel = " + responseModel);
        return responseModel;
    }

    @Override
    @ExecutionTime
    public ResponseModel getAllOrWithAuthorOrTitle(String searchParam, String searchValue) {
//        System.out.println("searchParam = " + searchParam);
        if (searchParam == null) {
            return getAll();
        } else if (searchParam.equals("author")) {
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setData(postRepo.findAllByAuthor(searchValue));
            return responseModel;
        } else if (searchParam.equals("title")) {
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setData(postRepo.findAllByTitle(searchValue));
            return responseModel;
        } else if (searchParam.equals("titlesIn")) {
            return getAllWithinTitle();
        } else {
            return getAll();
        }
    }

    @Override
    public ResponseModel findById(int id) {
        try {
            int a = 0;
            int b = 0 / a;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(modelMapper.map(postRepo.findById((long) id), PostDTO.class));
        return responseModel;
    }

    @Override
    public ResponseModel save(Post post) {
        postRepo.save(post);
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setMessage("Post has been saved successfully.");
        return responseModel;
    }

    @Override
    public ResponseModel update(Post post) {
        postRepo.save(post);
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setMessage("POST has been updated successfully.");
        return responseModel;
    }

    @Override
    public ResponseModel delete(int id) {
        postRepo.deleteById((long) id);
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setMessage("Post has been deleted successfully");
        return responseModel;
    }

    @Override
    public ResponseModel getAllWithinTitle() {
        responseModel.setData(postRepo.findAllByTitleIn("aaa", "bbb"));
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }
}
