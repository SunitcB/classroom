package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    List<Post> findAllByAuthor(String srcAuthor);
    Post findById(int id);
    boolean save(Post post);
    boolean update(Post post);
    boolean delete(int id);
}
