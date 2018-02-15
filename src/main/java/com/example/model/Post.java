package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private String description;
    private String image;
    private int shares;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="author_id")
    private Author author;

    public Post() {
    }

    public Post(String title, String description, String image, int shares, Author author) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.shares = shares;
        this.author = author;
    }
    public Post(String id, String title, String description, String image, int shares, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.shares = shares;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", shares=" + shares +
                ", author=" + author +
                '}';
    }
}
