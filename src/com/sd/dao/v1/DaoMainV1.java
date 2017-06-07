package com.sd.dao.v1;

public class DaoMainV1 {
    public static void main(String[] args) {
        Person p;
        PersonDao personDao = new PersonDaoImpl();

        System.out.println("--- inserting...");
        p = new Person(0, "js1");
        personDao.insert(p);
        p = new Person(1, "js2");
        personDao.insert(p);

        System.out.println("--- finding all...");
        for (Person pi:personDao.findAll()) {
            System.out.println("reading... "+pi.getId() +", "+pi.getName());
        }

        System.out.println("--- updating...");
        p =personDao.findAll().get(0);
        p.setName("js new");
        personDao.update(p);

        System.out.println("--- see if updated...");
        p=personDao.findById(0);
        System.out.println(p.getId() +", "+p.getName());

        System.out.println("--- deleting...");
        personDao.delete(0);

        System.out.println("--- finding all after deleting...");
        for (Person pi:personDao.findAll()) {
            System.out.println("reading... "+pi.getId() +", "+pi.getName());
        }
   }
}