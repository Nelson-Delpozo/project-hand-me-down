package com.projecthandmedown.models;
import org.hibernate.mapping.ToOne;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "forum_replies")
public class ForumReply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String timestamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "forum_post_id")
    private ForumPost forumPost;

    public ForumReply() {}

    public ForumReply(String body) {
        this.body = body;
    }

    public ForumReply(String body, String timestamp, User user, ForumPost forumPost) {
        this.body = body;
        this.timestamp = timestamp;
        this.user = user;
        this.forumPost = forumPost;
    }

    public ForumReply(long id, String body, String timestamp, User user, ForumPost forumPost) {
        this.id = id;
        this.body = body;
        this.timestamp = timestamp;
        this.user = user;
        this.forumPost = forumPost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public void setForumPost(ForumPost forumPost) {
        this.forumPost = forumPost;
    }
}

