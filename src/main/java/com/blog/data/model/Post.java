package com.blog.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NonNull
    private String title;
    @NonNull
    private String body;
    @NonNull
    private LocalDate dateOfPost;
    private String imageUrl;
}
