package com.example.repository;

import com.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    @Query(value = "select p from Post p where p.shares > 500 order by p.shares")
    List<Post> getTopPosts();

    @Query(value = "select p from Post p join p.author author where p.shares > 500 and author.name like %?1 order by p.shares")
    List<Post> getTopPostsByName(String name);


    Optional<Post> findById(String id);

}