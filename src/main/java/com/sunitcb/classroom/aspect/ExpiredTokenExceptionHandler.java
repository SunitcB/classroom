package com.sunitcb.classroom.aspect;

import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExpiredTokenExceptionHandler {
    private final JwtUtil jwtUtil;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseModel> returnRenewedToken(ExpiredJwtException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(jwtUtil.getRenewedAccessToken(e.getClaims().getSubject()));
        responseModel.setStatusCode(HttpStatus.CONTINUE.value());
        responseModel.setMessage("Access token has been renewed");
        return ResponseEntity.status(HttpStatus.CONTINUE.value()).body(responseModel);
    }
}
