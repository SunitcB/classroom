package com.sunitcb.classroom.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResponseModel {
    private Object data;
    private int statusCode;
    private String message;
}
