package com.blog.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CommentDto {

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    private String comment;
    private String commenter;


}