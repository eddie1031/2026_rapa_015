package io.eddie.restapi.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    private Long id;

    private String title;
    private String contents;

    private String author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
