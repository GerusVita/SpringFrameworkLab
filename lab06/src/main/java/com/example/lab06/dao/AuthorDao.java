package com.example.lab06.dao;

import com.example.lab06.config.DatabaseConfig;
import com.example.lab06.domain.Author;
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

class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setFullName(rs.getString("full_name"));
        return author;
    }
}
@Repository
public class AuthorDao implements IAuthorDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("author").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Author> allAuthor() {
        List<Map<String, Object>> query = jdbcTemplate.queryForList("select* from author");
        List<Author> result = new ArrayList<>();
        for (Map<String, Object> map : query) {
            Author author = new Author((long) map.get("id"), (String) map.get("full_name"));
            result.add(author);
        }
        return result;
    }

    @Override
    public Author getOneById(long id) {
        return jdbcTemplate.queryForObject("select* from author where id = ?",new Object[] {id}, new AuthorRowMapper());
    }

    @Override
    public long create(Author author) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("full_name", author.getFullName());
        //return id
        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        long id = number.longValue();
        return id;
    }

    @Override
    public int update(Author author) {
        return jdbcTemplate.update("update author set full_name = ? where id = ? ",author.getFullName(),author.getId());
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from author where id = ? ",id);
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("delete from author");
    }

}
