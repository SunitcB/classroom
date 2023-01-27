package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.dto.LoginRequestDTO;
import com.sunitcb.classroom.domain.dto.LoginResponseDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.LoginService;
import com.sunitcb.classroom.service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authManager;
    private final ClassroomUserDetailService classUserDetailService;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseModel authenticateUser(LoginRequestDTO loginRequestObj) {
        Authentication authentication = null;
        ResponseModel responseModel = new ResponseModel();
        try {
            authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestObj.getUsername(), loginRequestObj.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException(ex.getMessage());
        }

        UserDetails userDetails = classUserDetailService.loadUserByUsername(loginRequestObj.getUsername());
        String accessToken = jwtUtil.generateToken(userDetails);
        String refreshToken = jwtUtil.generateRefreshToken(loginRequestObj.getUsername());
        LoginResponseDTO loginResponseObj = new LoginResponseDTO();
        loginResponseObj.setAccessToken(accessToken);
        loginResponseObj.setRefreshToken(refreshToken);
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setData(loginResponseObj);
        return responseModel;
    }
}
