package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.ExceptionLog;
import com.sunitcb.classroom.repo.ExceptionRepo;
import com.sunitcb.classroom.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Autowired
    ExceptionRepo exceptionRepo;

    @Override
    public void saveException(ExceptionLog ex) {
        exceptionRepo.save(ex);
    }
}
