package org.example.dao;

import org.example.domain.Person;
//find
public class PersonDaoSimple implements PersonDao{
    public Person findBySurname(String surname){
        return new Person("",surname);
    }
}
