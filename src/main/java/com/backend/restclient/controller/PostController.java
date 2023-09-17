package com.backend.restclient.controller;

import com.backend.restclient.client.JsonPlaceholderService;
import com.backend.restclient.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceholderService postService;

    public PostController(JsonPlaceholderService postService) {
        this.postService = postService;
    }

    /*
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
     */

    @GetMapping
    List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Post update(@PathVariable Integer id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        postService.delete(id);
    }
}
