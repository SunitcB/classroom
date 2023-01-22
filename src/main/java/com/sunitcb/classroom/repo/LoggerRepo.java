package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
