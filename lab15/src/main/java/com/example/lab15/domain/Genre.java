package com.example.lab14.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return title.equals(genre.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
