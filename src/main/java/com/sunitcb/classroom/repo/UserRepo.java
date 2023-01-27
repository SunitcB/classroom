package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Comment;
import com.sunitcb.classroom.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    @Query("select u from User u join u.posts p group by u having count(p) = :num")
    List<User> findAllWithMorePosts(Integer num);

    @Query("select c from User u left join u.posts p left join p.comments c where u.id = :userId and p.id = :postId and c.id = :commentId")
    List<Comment> findCommentByTraversal(int userId, int postId, int commentId);

    User findByEmail(String email);
}
