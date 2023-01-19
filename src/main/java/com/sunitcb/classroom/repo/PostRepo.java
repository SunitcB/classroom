package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAllByAuthor(String srcAuthor);
}
