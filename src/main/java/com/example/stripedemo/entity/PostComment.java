package com.example.stripedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString(exclude = "post")
@Entity
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    public void setPost(Post p) {
        this.post = p;
        post.getComments().add(this);
    }
}
