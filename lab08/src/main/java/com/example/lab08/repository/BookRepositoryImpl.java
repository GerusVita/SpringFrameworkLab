package com.example.lab08.repository;

import com.example.lab08.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Book getById(long id) {
        return manager.find(Book.class,id);
    }

    @Override
    public List<Book> getAll() {
        Query query = manager.createQuery("SELECT e from Book e", Book.class);
        return query.getResultList();    }

    @Override
    public Book create(Book book) {
        return manager.merge(book);
    }

    @Override
    public void update(Book book) {
        Query query = manager.createQuery("UPDATE Book a set a.title = :name, a.author.id=:author,a.genre.id=:genre where a.id =:id");
        query.setParameter("name",book.getTitle());
        query.setParameter("author",book.getAuthor().getId());
        query.setParameter("genre",book.getGenre().getId());
        query.setParameter("id",book.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteElement(Book book) {
        manager.remove(book);
    }

    @Override
    public void deleteAll() {
        Query query = manager.createQuery("delete from Book a");
        query.executeUpdate();
    }
}
