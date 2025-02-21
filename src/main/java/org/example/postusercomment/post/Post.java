package org.example.postusercomment.post;

public class Post {

    private Long id;
    private String title;
    private String description;
    private Long userId;

    public Post(Long id, String title, String description, Long userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.id = id;
    }

    public Post() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
