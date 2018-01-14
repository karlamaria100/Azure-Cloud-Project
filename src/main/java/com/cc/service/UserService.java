package com.cc.service;

import com.cc.abst.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cc.model.User;

import java.util.HashSet;
import com.cc.abst.GenericRepository;
import com.cc.model.User;
import com.cc.repository.UserRepository;

/**
 * Created by Karla on 11-Jan-18.
 */
@Service
public class UserService extends AbstractService<User,Long> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public GenericRepository<User, Long> getDao() {
        return null;
    }
    
    public void saveUser(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	
    	userRepository.save(user);
    }
    
    public User findByUsername(String username) {
    	return userRepository.findByUsername(username);
    }
}
