package com.example.services;

import com.example.model.Post;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository repo;

    @Autowired
    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(String postID) {

    }


    @Override
    public void savePost(Post post) {

    }

    @Override
    public List<Post> listPosts() {
        return repo.findAll();
    }

    @Override
    public List<Post> listPostsWithMoreShares() {
        return null;
    }

    @Override
    public Post getPostByID(String id) {
        return repo.findOne(id);
    }

    @Override
    public List<Post> getTopPosts() {
        return null;
    }

}
