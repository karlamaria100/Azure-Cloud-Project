package com.cc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Karla on 11-Jan-18.
 */
@Table(name = "posts")
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "numberOFLikes")
    private int like;

    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;

    @Column(name = "time_stamp")
    private Date timeStamp;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(targetEntity = Comment.class, mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(targetEntity = Like.class, mappedBy = "post",cascade = CascadeType.ALL)
    private List<Like> likes;

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
