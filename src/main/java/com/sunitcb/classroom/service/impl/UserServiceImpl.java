package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.User;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.UserRepo;
import com.sunitcb.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ResponseModel responseModel;

    @Autowired
    UserServiceImpl(UserRepo userRepo, ResponseModel responseModel) {
        this.userRepo = userRepo;
        this.responseModel = responseModel;
    }

    @Override
    public ResponseModel getAllUsers(boolean filter, Integer num) {
        if (filter) {
            responseModel.setData(userRepo.findAllWithMorePosts(num));
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(userRepo.findAll());
            responseModel.setStatusCode(HttpStatus.OK.value());
        }
        return responseModel;
    }

    @Override
    public ResponseModel getUserById(int id) {
        responseModel.setData(userRepo.findById((long) id).get());
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
        responseModel.setMessage("User has been created successfully.");
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel updateUser(User user) {
        userRepo.save(user);
        responseModel.setMessage("User has been updated successfully.");
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel deleteUser(int id) {
        userRepo.deleteById((long) id);
        responseModel.setMessage("User has been deleted successfully.");
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel getPostsByUser(int userId) {
        responseModel.setData(userRepo.findById((long) userId).get().getPosts());
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel getUsersWithManyPosts(int num) {
        responseModel.setData(userRepo.findAllWithMorePosts(num));
        responseModel.setStatusCode(HttpStatus.OK.value());
        return responseModel;
    }

    @Override
    public ResponseModel getUserByTraversal(int userId, int postId, int commentId) {
        responseModel.setData(userRepo.findCommentByTraversal(userId, postId, commentId));
        responseModel.setStatusCode(HttpStatus.OK.value());
        System.out.println(responseModel);
        return responseModel;
    }
}
