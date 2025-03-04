package org.example.postusercomment.post;

import org.example.postusercomment.user.User;
import org.example.postusercomment.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("/{user_id}")
    public void createPost(@PathVariable Long user_id, @RequestParam String title, @RequestParam String description) {
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setUserId(user_id);
        postService.createPost(post);
    }

    @PostMapping("/{user_id}/{post_id}")
    public void updatePost(@PathVariable Long user_id, @PathVariable Long post_id, @RequestParam String title, @RequestParam String description) {
        Post post = new Post();
        post.setId(post_id);
        post.setTitle(title);
        post.setDescription(description);
        post.setUserId(user_id);
        postService.updatePost(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/users/{user_id}")
    public List<Post> getPostsByUserId(@PathVariable Long user_id) {
        boolean userExists = userService.checkIfExistsById(user_id);
        if (!userExists) {
            throw new RuntimeException("User with id " + user_id + " does not exist.");
        }
        return postService.getPostsByUser(user_id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
