package com.example.lab05.dao;

import com.example.lab05.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao{
    public PersonDaoImpl() {
    }

    public Person findBySurname(String surname){
        return new Person("",surname);
    }

    @Override
    public String printPersone(Person person) {
        return person.getName()+" "+person.getSurname();
    }
}
