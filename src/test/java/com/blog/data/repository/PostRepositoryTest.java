package com.blog.data.repository;

import com.blog.data.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void createPost(){
        Post post = new Post("The Continuing Path", "Of all notable innovative journeys, one thing can be rightly said; there must be an alienation of the traveller’s vision from the status quo.",
                LocalDate.now(), "https://images.app.goo.gl/9q1TrMJGinLqDqy37");
        postRepository.save(post);
        assertNotNull(post);
    }

    @Test
    void updatePostById(){
        Optional<Post> optionalPost = postRepository.findById(1L);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setTitle("Best foods to buy in Sabo");
            postRepository.save(post);
            assertEquals("Best foods to buy in Sabo", post.getTitle());
        }
    }

    @Test
    void deletePostById(){
        Optional<Post> optionalPost = postRepository.findById(2L);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            postRepository.deleteById(post.getPostId());
            assertEquals(1, postRepository.count());
        }
    }
}