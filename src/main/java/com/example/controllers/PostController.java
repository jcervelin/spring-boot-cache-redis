package com.example.controllers;

import com.example.exceptions.PostNotFoundException;
import com.example.model.Post;
import com.example.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/posts")
@EnableScheduling
@Transactional
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Cacheable(value = "post-single", key = "#id", unless = "#result.shares < 500")
    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable String id) throws PostNotFoundException {
        log.info("get post with id {}", id);
        return postService.getPostByID(id);
    }

    @PostMapping
    public Post savePostByID(@RequestBody Post post) throws PostNotFoundException {
        log.info("update post with id {}", post.getId());
        return postService.savePost(post);
    }

    @CachePut(value = "post-single", key = "#post.id")
    @PutMapping
    public Post updatePostByID(@RequestBody Post post) throws PostNotFoundException {
        log.info("update post with id {}", post.getId());
        postService.updatePost(post);
        return post;
    }

    @CacheEvict(value = "post-single", key = "#id")
    @DeleteMapping("/{id}")
    public void deletePostByID(@PathVariable String id) {
        log.info("delete post with id {}", id);
        postService.deletePost(id);
    }

    @Cacheable(value = "post-top", key = "'post'")
    @GetMapping("/top")
    public List<Post> getTopPosts() {
        log.info("List the tops (more than 500 shares)");
        return postService.getTopPosts();
    }

    @GetMapping("/top/names/{name}")
    public List<Post> getTopPostsByName(@PathVariable("name") String name) {
        log.info("List a name among the tops", name);
        return postService.getTopPostsByName(name);
    }

    @Scheduled(fixedDelayString = "${spring.cache.fixedDelay}")
    @CacheEvict(value = "post-top", key = "'post'")
    @GetMapping("/top/evict")
    public void evictTopPosts() {
        log.info("Evict post-top");
    }

    @GetMapping
    public List<Post> listPosts() {
        log.info("list all");
        return postService.listPosts();
    }

    @CacheEvict(value = "*", allEntries = true, key = "'*'")
    @GetMapping("/clear")
    public void clearCache() {
        log.info("clear cache");
    }

}

