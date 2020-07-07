package com.example.lab04.dao;

import com.example.lab04.domain.Person;
import org.springframework.stereotype.Repository;

public interface PersonDao {
    Person findBySurname(String surname);
}
