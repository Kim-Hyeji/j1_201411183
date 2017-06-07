package com.sd.dao.v1;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    List<Person> persons;
    public PersonDaoImpl() {
        persons = new ArrayList<Person>();
    }
    public void insert(Person p) {
        persons.add(p);
    }
    public List<Person> findAll() {
        return persons;
    }
    public Person findById(int id) {
        return persons.get(id);
    }
    public void update(Person p) {
        persons.get(p.getId()).setName(p.getName());
        System.out.println("updating... "+p.getId());
    }
    public void delete(int id) {
        persons.remove(id);
    }
    public void delete(Person p) {
        persons.remove(p.getId());
        System.out.println("deleting... "+p.getId());
    }
}