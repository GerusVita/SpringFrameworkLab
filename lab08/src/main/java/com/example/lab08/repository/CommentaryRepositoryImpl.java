package com.example.lab08.repository;

import com.example.lab08.domain.Commentary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class CommentaryRepositoryImpl implements CommentaryRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Commentary getById(long id) {
        return manager.find(Commentary.class,id);
    }

    @Override
    public List<Commentary> getAll() {
        Query query = manager.createQuery("select e from Commentary e",Commentary.class);
        return query.getResultList();
    }

    @Override
    public Commentary create(Commentary com) {
        return manager.merge(com);
    }

    @Override
    public void update(Commentary com) {
        Query query = manager.createQuery("update Commentary c set c.text=:text, c.book.id=:book, c.reader.id =: reader where c.id =:id ");
        query.setParameter("text",com.getText());
        query.setParameter("book",com.getBook().getId());
        query.setParameter("reader",com.getReader().getId());
        query.setParameter("id",com.getId());
        query.executeUpdate();

    }

    @Override
    public void deleteElement(Commentary com) {
        manager.remove(com);
    }

    @Override
    public void deleteAll() {
        Query query = manager.createQuery("delete from Commentary com");
        query.executeUpdate();
    }
}
