package com.blog.data.repository;

import com.blog.data.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    void createComment(){
        Comment comment = new Comment("This looks delicious", LocalTime.now(), "Tasha");
        Comment comment1 = new Comment("Dripping hot noodles", LocalTime.now(), "Jacob");
        commentRepository.save(comment);
        commentRepository.save(comment1);
        assertNotNull(comment);
    }

    @Test
    void updateCommentById(){
        Optional<Comment> optionalComment = commentRepository.findById(1L);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setTime(LocalTime.of(16, 32, 54));
            commentRepository.save(comment);
            assertEquals(LocalTime.of(16, 32, 54), comment.getTime());
        }
    }

    @Test
    void deleteCommentById(){
        Optional<Comment> optionalComment = commentRepository.findById(2L);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            commentRepository.deleteById(comment.getCommentId());
            assertEquals(1, commentRepository.count());
        }
    }

}