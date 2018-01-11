package com.cc.repository;

import com.cc.abst.GenericRepository;
import com.cc.model.Comment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Karla on 11-Jan-18.
 */
@Transactional
@Repository
public interface CommentRepository extends GenericRepository<Comment,Long> {
}
