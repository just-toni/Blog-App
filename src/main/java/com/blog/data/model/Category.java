package com.blog.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Post> posts;

}
