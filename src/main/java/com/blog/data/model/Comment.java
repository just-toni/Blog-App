package com.blog.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @NonNull
    private String comment;
    @NonNull
    private LocalTime time;
    @ManyToOne
    private Category categories;
    @ManyToOne
    private Post posts;
}
