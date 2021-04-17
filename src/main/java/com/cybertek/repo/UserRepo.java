package com.cybertek.repo;

import com.cybertek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
    List<User> findAllByRoleNameIgnoreCase(String role);
}
