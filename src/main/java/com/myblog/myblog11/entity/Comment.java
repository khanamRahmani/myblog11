package com.myblog.myblog11.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String email;
    private String text;
    //many comments for one post
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

}
