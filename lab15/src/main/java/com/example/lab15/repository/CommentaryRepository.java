package com.example.lab14.repository;


import com.example.lab14.domain.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary,Long> {
    List<Commentary> findCommentaryByReader(String name);
}
