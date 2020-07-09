package com.example.lab06.dao;

import com.example.lab06.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor_id(rs.getInt("author_id"));
        book.setGenre_id(rs.getInt("genre_id"));
        return book;
    }
}

@Repository
public class BookDao implements IBookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("book").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Book> allBook() {
        List<Map<String, Object>> query = jdbcTemplate.queryForList("select* from book");
        List<Book> result = new ArrayList<>();
        for (Map<String, Object> map : query) {
            Book book = new Book((long) map.get("id"), (String) map.get("title"),(long) map.get("author_id"),(long) map.get("genre_id"));
            result.add(book);
        }
        return result;
    }

    @Override
    public Book getOneById(long id) {
        return jdbcTemplate.queryForObject("select* from book where id = ?",new Object[] {id},new BookRowMapper());
    }

    @Override
    public long create(Book book) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("title", book.getTitle());
        parameters.put("author_id", book.getAuthor_id());
        parameters.put("genre_id", book.getGenre_id());
        //return long id
        return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
    }

    @Override
    public int update(Book book) {
       return jdbcTemplate.update("update book set title = ?, author_id = ?, genre_id = ? where id = ? ",book.getTitle(),book.getAuthor_id(),book.getGenre_id(),book.getId());
    }

    @Override
    public int deleteByID(long id) {
        return jdbcTemplate.update("delete from book where id = ? ",id);
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("delete from book");
    }
}
