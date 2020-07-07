package com.example.lab04.dao;

import com.example.lab04.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao{
    public PersonDaoImpl() {
    }

    public Person findBySurname(String surname){
        return new Person("",surname);
    }
}
