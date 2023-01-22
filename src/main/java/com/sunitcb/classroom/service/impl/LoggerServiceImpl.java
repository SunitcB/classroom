package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.Logger;
import com.sunitcb.classroom.repo.LoggerRepo;
import com.sunitcb.classroom.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepo loggerRepo;
    @Autowired
    LoggerServiceImpl(LoggerRepo loggerRepo){
        this.loggerRepo = loggerRepo;
    }

    @Override
    public void saveLog(Logger logger) {
        loggerRepo.save(logger);
    }
}
