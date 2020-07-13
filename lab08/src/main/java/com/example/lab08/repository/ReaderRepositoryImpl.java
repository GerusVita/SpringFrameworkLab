package com.example.lab08.repository;

import com.example.lab08.domain.Reader;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class ReaderRepositoryImpl implements ReaderRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Reader getById(long id) {
        return manager.find(Reader.class,id);
    }

    @Override
    public List<Reader> getAll() {
        Query query = manager.createQuery("select e from Reader e",Reader.class);
        return query.getResultList();
    }

    @Override
    public Reader create(Reader reader) {
        return manager.merge(reader);
    }

    @Override
    public void update(Reader reader) {
        Query query = manager.createQuery("update Reader r set r.name=:name where r.id=:id");
        query.setParameter("name",reader.getName());
        query.setParameter("id",reader.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteElement(Reader reader) {
        manager.remove(reader);
    }

    @Override
    public void deleteAll() {
        Query query = manager.createQuery("delete from Reader r");
        query.executeUpdate();
    }
}
