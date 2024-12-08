package com.mergency.crudapp.repository;

import java.util.List;
import com.mergency.crudapp.entity.Person;

public interface PersonDAO {
    void save(Person person);

    void delete(Integer id);

    Person get(Integer id);

    List<Person> getAll();

    void update(Person person);
}
