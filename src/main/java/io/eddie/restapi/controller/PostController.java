package io.eddie.restapi.controller;

import io.eddie.restapi.dto.SavePostRequest;
import io.eddie.restapi.dto.UpdatePostRequest;
import io.eddie.restapi.entity.Post;
import io.eddie.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository repository;

    // 다건조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK) // 200
    public ResponseEntity<List<Object>> getPosts() {

        List<Object> objects = List.of();

        return ResponseEntity.ok(
                objects
        );

    }

    // 단건조회
    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK) // 201
    public ResponseEntity<Post> getPost(
            @PathVariable Long postId
    ) {
        Post findPost = repository.findById(postId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findPost);

    }

    // 게시물 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseEntity<Post> savePost(
            @RequestBody SavePostRequest request
    ) {
        Post findPost = repository.save(Post.of(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(findPost);

    }

    // 특정 게시물 수정
    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK) // 200
    public ResponseEntity<Post> updatePost(
            @PathVariable Long postId,
            @RequestBody UpdatePostRequest request
    ) {
        Post updated = repository.update(postId, request);
        return ResponseEntity.ok(updated);
    }

    // 특정 게시물 삭제
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public ResponseEntity<Void> deletePost(
            @PathVariable Long postId
    ) {
        repository.deleteById(postId);
        return ResponseEntity.noContent().build();
    }

}
