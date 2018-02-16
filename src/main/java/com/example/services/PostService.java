package com.example.services;

import com.example.exceptions.PostNotFoundException;
import com.example.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post updatePost(Post post) throws PostNotFoundException;

    void deletePost(String postID);

    Post savePost(Post post) throws PostNotFoundException;

    List<Post> listPosts();

    List<Post> listPostsWithMoreShares();

    Post getPostByID(String id) throws PostNotFoundException;

    List<Post> getTopPostsByName(String name);

    List<Post> getTopPosts();
}
