package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.ExceptionLog;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<ExceptionLog, Long> {
}
