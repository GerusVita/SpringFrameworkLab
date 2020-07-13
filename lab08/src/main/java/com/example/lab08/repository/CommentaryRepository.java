package com.example.lab08.repository;


import com.example.lab08.domain.Commentary;

import java.util.List;

public interface CommentaryRepository {
    Commentary getById(long id);
    List<Commentary> getAll();
    Commentary create(Commentary com);
    void update(Commentary com);
    void deleteElement(Commentary com);
    void deleteAll();
}
