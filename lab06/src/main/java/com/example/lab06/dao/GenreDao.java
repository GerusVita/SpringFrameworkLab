package com.example.lab06.dao;

import com.example.lab06.config.DatabaseConfig;
import com.example.lab06.domain.Author;
import com.example.lab06.domain.Genre;
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

class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setTitle(rs.getString("title"));
        return genre;
    }
}
@Repository
public class GenreDao implements IGenreDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("genre").usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Genre> allGenre() {
        List<Map<String, Object>> query = jdbcTemplate.queryForList("select* from genre");
        List<Genre> result = new ArrayList<>();
        for (Map<String, Object> map : query) {
            Genre genre = new Genre((long) map.get("id"), (String) map.get("title"));
            result.add(genre);
        }
        return result;
    }

    @Override
    public Genre getOneById(long id) {
        return jdbcTemplate.queryForObject("select* from genre where id = ?",new Object[] {id}, new GenreRowMapper());
    }

    @Override
    public long create(Genre genre) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("title", genre.getTitle());
        //return id
        return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
    }

    @Override
    public int update(Genre genre) {
        return jdbcTemplate.update("update genre set title = ? where id = ? ",genre.getTitle(),genre.getId());
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("delete from genre");
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from genre where id = ? ",id);
    }
}
