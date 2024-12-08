package com.mergency.crudapp.repository;

import javax.swing.text.html.parser.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mergency.crudapp.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository implements PersonDAO {

    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    public Person get(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = entityManager.createQuery("FROM Person", Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person);
    }
}