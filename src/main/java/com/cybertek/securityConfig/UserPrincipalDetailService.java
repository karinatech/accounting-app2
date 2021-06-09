package com.cybertek.securityConfig;

import com.cybertek.entity.User;
import com.cybertek.repo.UserRepo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserPrincipalDetailService implements UserDetailsService {
    private UserRepo userRepo;

    public UserPrincipalDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user= userRepo.findByEmail(s);
      UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
