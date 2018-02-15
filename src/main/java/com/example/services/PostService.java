package com.example.services;

import com.example.model.Post;

import java.util.List;

public interface PostService {
    void updatePost(Post post);

    void deletePost(String postID);

    void savePost(Post post);

    List<Post> listPosts();

    List<Post> listPostsWithMoreShares();

    Post getPostByID(String id);

    List<Post> getTopPosts();
}
