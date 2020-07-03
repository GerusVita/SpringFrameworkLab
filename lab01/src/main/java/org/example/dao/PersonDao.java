package org.example.dao;

import org.example.domain.Person;

public interface PersonDao {
    Person findBySurname(String surname);
}
