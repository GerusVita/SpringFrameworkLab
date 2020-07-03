package org.example.domain;

public class Person {
    private String name;
    private String surname;
    private int result;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null)
        this.name = name;
        else this.name = "";
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        if(result<0)
            this.result = 0;
        else
        if (result>100)
            this.result =100;
        else
        this.result = result;
    }

}
