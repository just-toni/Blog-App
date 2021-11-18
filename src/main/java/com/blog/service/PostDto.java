package com.blog.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDto {

    private String title;
    private String body;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfPost;
    private String imageUrl;

}