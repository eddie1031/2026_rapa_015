package io.eddie.restapi.repository;

import io.eddie.restapi.entity.Post;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {

    private Map<Long, Post> db = new HashMap<>();

    @Getter
    private Long sequence = 0L;

    public Post save(Post post) {

        sequence++;

        post.setId(sequence);
        db.put(post.getId(), post);

        return post;

    }

    public Post findById(Long id) {
        return db.get(id);
    }

    public void deleteById(Long id) {
        db.remove(id);
    }

    public Post update(Long id) {

        Post findPost = db.get(id);

        return db.replace(findPost.getId(), findPost);

    }

}
