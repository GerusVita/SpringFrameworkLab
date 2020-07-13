package com.example.lab08.repository;

import com.example.lab08.domain.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository {

@PersistenceContext
private EntityManager manager;

    @Override
    public Author getById(long id) {
        return manager.find(Author.class,id);
    }

    @Override
    public List<Author> getAll() {
        Query query = manager.createQuery("SELECT e from Author e", Author.class);
        return query.getResultList();
    }

    @Override
    public Author create(Author author) {
        return manager.merge(author);
    }

    @Override
    public void update(Author author) {
        Query query = manager.createQuery("UPDATE Author a set a.fullName = :name where a.id =:id");
        query.setParameter("name",author.getFullName());
        query.setParameter("id",author.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteElement(Author author) {
            manager.remove(author);
    }

    @Override
    public void deleteAll() {
        Query query = manager.createQuery("delete from Author a");
        query.executeUpdate();
    }
}
