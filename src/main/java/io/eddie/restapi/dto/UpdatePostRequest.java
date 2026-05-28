package io.eddie.restapi.dto;

public record UpdatePostRequest(
    String title,
    String contents
) {
}

/*

    {
        "title": "...",
        "contents": "..."
    }

 */
