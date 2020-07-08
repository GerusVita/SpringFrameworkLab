package com.example.lab05.dao;

import com.example.lab05.domain.Person;

public interface PersonDao {
    Person findBySurname(String surname);
    String printPersone(Person person);
}
