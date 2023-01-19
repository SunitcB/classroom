package com.sunitcb.classroom.service;

import com.sunitcb.classroom.domain.User;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseModel getAllUsers(boolean filter);
    ResponseModel getUserById(int id);
    ResponseModel saveUser(User user);
    ResponseModel updateUser(User user);
    ResponseModel deleteUser(int id);
    ResponseModel getPostsByUser(int userId);
    ResponseModel getUsersWithManyPosts();
}
