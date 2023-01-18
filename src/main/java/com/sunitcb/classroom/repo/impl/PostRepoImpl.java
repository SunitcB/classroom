package com.sunitcb.classroom.repo.impl;

import com.sunitcb.classroom.domain.Post;
import com.sunitcb.classroom.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private List<Post> posts = new ArrayList<>();

    PostRepoImpl() {
        this.posts.add(new Post(1, "Something", "Something", "Something"));
        this.posts.add(new Post(2, "Another Thing", "Another Thing", "Another Thing"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<Post> findAllByAuthor(String srcAuthor) {
        return posts.stream().filter(x -> x.getAuthor().equals(srcAuthor)).toList();
    }

    @Override
    public Post findById(int id) {
        return posts.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public boolean save(Post post) {
        long newId = this.posts.stream().map(x -> x.getId()).max(Long::compare).get() + 1;
        post.setId(newId);
        this.posts.add(post);
        return true;
    }

    @Override
    public boolean update(Post post) {
        Post updateObj = findById((int) post.getId());
        updateObj.setAuthor(post.getAuthor());
        updateObj.setContent(post.getContent());
        updateObj.setTitle(post.getTitle());
        return true;
    }

    @Override
    public boolean delete(int id) {
        Post deleteObj = findById(id);
        this.posts.remove(deleteObj);
        return true;
    }
}
