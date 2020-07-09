package com.example.lab06.domain;


import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private long author_id;
    private long genre_id;

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return author_id == book.author_id &&
                genre_id == book.genre_id &&
                title.equals(book.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author_id=" + author_id +
                ", genre_id=" + genre_id +
                '}';
    }

    public Book(String title, long author_id, long genre_id) {
        this.title = title;
        this.author_id = author_id;
        this.genre_id = genre_id;
    }

    public Book(long id, String title, long author_id, long genre_id) {
        this.id = id;
        this.title = title;
        this.author_id = author_id;
        this.genre_id = genre_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }
}
