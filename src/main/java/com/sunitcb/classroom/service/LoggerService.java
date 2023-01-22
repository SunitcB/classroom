package com.sunitcb.classroom.service;

import com.sunitcb.classroom.domain.Logger;
import com.sunitcb.classroom.repo.LoggerRepo;

public interface LoggerService {
    void saveLog(Logger logger);
}
