package org.example.postusercomment.post;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Post> postRowMapper = (rs, rowNum) ->
            new Post(rs.getLong("id"), rs.getString("title"), rs.getString("description"), rs.getLong("user_id"));

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, description, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getUserId());
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, postRowMapper, id);
    }

    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, postRowMapper);
    }

    public void update(Post post) {
        String sql = "UPDATE posts SET title = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Post> findAllByUserId(Long userId) {
        String sql = "SELECT * FROM posts WHERE user_id = ?";
        return jdbcTemplate.query(sql, postRowMapper, userId);
    }
}
