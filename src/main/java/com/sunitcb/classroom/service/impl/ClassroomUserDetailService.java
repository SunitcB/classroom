package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.domain.User;
import com.sunitcb.classroom.domain.dto.ClassUserDetails;
import com.sunitcb.classroom.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassroomUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    ClassroomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userObj = userRepo.findByEmail(username);
        ClassUserDetails classUserDetails = new ClassUserDetails();
        classUserDetails.setUsername(userObj.getEmail());
        classUserDetails.setPassword(userObj.getPassword());
        classUserDetails.setRoles(userObj.getRoles());
        return classUserDetails;
    }
}
