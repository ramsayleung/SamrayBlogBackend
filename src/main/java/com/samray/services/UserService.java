package com.samray.services;

import com.samray.domains.User;
import com.samray.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 2/7/17
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
