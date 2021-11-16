package com.blog.service;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDto {

    private LocalDate time;
    private String comment;
    private String commenter;


}
