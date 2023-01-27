package com.sunitcb.classroom.controller;

import com.sunitcb.classroom.domain.dto.LoginRequestDTO;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthenticateController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseModel> login(@RequestBody LoginRequestDTO loginRequestObj) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.authenticateUser(loginRequestObj));
    }

    @GetMapping
    public ResponseEntity<ResponseModel> login(@RequestParam String username, @RequestParam String password) {
        LoginRequestDTO loginRequestObj = new LoginRequestDTO(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(loginService.authenticateUser(loginRequestObj));
    }
}
