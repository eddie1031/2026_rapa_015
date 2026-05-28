package io.eddie.restapi.dto;

public record SavePostRequest(
    String title,
    String contents,
    String author
) {
}

/*

    {
        "title": "...",
        "contents": "...",
        "author": "..."
    }

 */
