package com.example.services;

import com.example.exceptions.PostNotFoundException;
import com.example.model.Author;
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
    public Post updatePost(Post post) throws PostNotFoundException {
        Post attachedPost = getPostByID(post.getId());
        Author author = attachedPost.getAuthor();
        author.setName(post.getAuthor().getName());
        attachedPost.setDescription(post.getDescription());
        attachedPost.setImage(post.getImage());
        attachedPost.setShares(post.getShares());
        attachedPost.setTitle(post.getTitle());
        return savePost(attachedPost);
    }

    @Override
    public void deletePost(String postID) {
        repo.delete(postID);
    }


    @Override
    public Post savePost(Post post) {
        return repo.save(post);
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
    public Post getPostByID(String id) throws PostNotFoundException {
        return repo.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public List<Post> getTopPosts() {
        return repo.getTopPosts();
    }

    public List<Post> getTopPostsByName(String name) {
        return repo.getTopPostsByName(name);
    }

}
