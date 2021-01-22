package com.jiang.missyou.service;

import com.jiang.missyou.model.User;
import com.jiang.missyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }
}
