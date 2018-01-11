package com.cc.repository;

import com.cc.abst.GenericRepository;
import com.cc.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Karla on 11-Jan-18.
 */
@Transactional
@Repository
public interface UserRepository extends GenericRepository<User,Long> {
}
