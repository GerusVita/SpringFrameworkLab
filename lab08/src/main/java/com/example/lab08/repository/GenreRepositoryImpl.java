package com.example.lab08.repository;

import com.example.lab08.domain.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class GenreRepositoryImpl implements GenreRepository {
    @PersistenceContext
    EntityManager manager;

    @Override
    public Genre getById(long id) {
        return manager.find(Genre.class,id);
    }

    @Override
    public List<Genre> getAll() {
        Query query = manager.createQuery("SELECT e from Genre e",Genre.class);
        return query.getResultList();
    }

    @Override
    public Genre create(Genre genre) {
        return manager.merge(genre);
    }

    @Override
    public void update(Genre genre) {
        Query query = manager.createQuery("UPDATE Genre g set g.title =:title where g.id=:id");
        query.setParameter("title",genre.getTitle());
        query.setParameter("id",genre.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteElement(Genre genre) {
        manager.remove(genre);
    }

    @Override
    public void deleteAll() {
        Query query = manager.createQuery("delete from Genre g");
        query.executeUpdate();
    }
}
