package com.cc.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Karla on 11-Jan-18.
 */
@Table(name = "comments")
@Entity(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "numberOFLikes")
    private int like;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post")
    private Post post;

    @OneToMany(targetEntity = Like.class, mappedBy = "comment",cascade = CascadeType.ALL)
    private List<Like> likes;

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
