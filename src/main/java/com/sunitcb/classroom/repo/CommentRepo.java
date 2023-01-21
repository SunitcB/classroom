package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {
}
