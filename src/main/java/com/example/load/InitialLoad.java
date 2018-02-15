package com.example.load;

import com.example.model.Author;
import com.example.model.Post;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialLoad  implements ApplicationRunner {

    @Autowired
    PostRepository repo;

    private List<Post> posts;

    @Override
    public void run(ApplicationArguments args) {

      posts = new ArrayList<>();
        posts.add(new Post("Cyberpunk is near", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Anna")));
        posts.add(new Post("Welcome aboard of the hype train", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Josh")));
        posts.add(new Post("How to improve programming skills ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Kobe")));
        posts.add(new Post("Top exercises for IT people", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Leo")));
        posts.add(new Post("Case study of 75 years project", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Tom")));
        posts.add(new Post( "Machine Learning", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Alexa")));
        posts.add(new Post( "Memory leaks, how to find them ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Frank")));
        posts.add(new Post( "Robots builds robots", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 155, new Author("Milagros")));
        posts.add(new Post("Quantum algorithms, from the scratch", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 455, new Author("Sarah")));
        posts.add(new Post("Coding, coding, coding", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Adam")));
        repo.save(posts);
    }
}
