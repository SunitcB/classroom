package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthor(String srcAuthor);
    List<Post> findAllByTitle(String title);
    List<Post> findAllByTitleIn(String ...titles);
}
