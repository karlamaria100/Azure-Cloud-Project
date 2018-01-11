package com.cc.model;

import javax.persistence.*;

/**
 * Created by Karla on 11-Jan-18.
 */
@Entity(name = "likes")
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name="post")
    private Post post;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne(targetEntity = Comment.class)
    @JoinColumn(name="comment")
    private Comment comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
