package com.cc.service;

import com.cc.abst.AbstractService;
import com.cc.abst.GenericRepository;
import com.cc.model.User;
import com.cc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Karla on 11-Jan-18.
 */
@Service
public class UserService extends AbstractService<User,Long> {

    @Autowired
    UserRepository userRepository;

    @Override
    public GenericRepository<User, Long> getDao() {
        return null;
    }
}
