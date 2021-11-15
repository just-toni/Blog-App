package com.blog.service;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDto {

    private String title;
    private String body;
    private LocalDate dateOfPost;
    private String imageUrl;

}
