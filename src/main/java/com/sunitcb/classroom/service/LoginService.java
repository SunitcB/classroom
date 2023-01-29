package com.sunitcb.classroom.service;

import com.sunitcb.classroom.domain.dto.LoginRequestDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;

public interface LoginService {
    ResponseModel authenticateUser(LoginRequestDTO loginRequestObj);
    ResponseModel renewAccessToken(String username);
}
