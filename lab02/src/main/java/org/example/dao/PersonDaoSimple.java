package org.example.dao;

import org.example.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoSimple implements PersonDao{
    public PersonDaoSimple() {
    }

    public Person findBySurname(String surname){
        return new Person("",surname);
    }
}
