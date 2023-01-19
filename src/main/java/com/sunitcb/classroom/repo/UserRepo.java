package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    @Query("select u from User u join u.posts p group by u having count(p) > 1")
    List<User> findAllWithMorePosts();
}
