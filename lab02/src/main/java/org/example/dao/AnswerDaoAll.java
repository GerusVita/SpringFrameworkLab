package org.example.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AnswerDaoAll implements AnswerDao{
    public AnswerDaoAll() {
    }

    @Override
    public List<String[]> readAllAnswer(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}
