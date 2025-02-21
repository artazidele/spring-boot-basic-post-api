package org.example.postusercomment.comment;

public class Comment {

    private Long id;
    private String message;
    private Long userId;
    private Long postId;

    public Comment() {}

    public Comment(Long id, String message, Long userId, Long postId) {
        this.id = id;
        this.message = message;
        this.userId = userId;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}

