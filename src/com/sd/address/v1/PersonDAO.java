package com.sd.address.v1;

import java.util.List;

public interface PersonDAO {
    public void insert(PersonVO person);
    public List<PersonVO> findAll();
    public PersonVO findByName(String name);
    public void update(PersonVO person);
    public String delete(String name);
}