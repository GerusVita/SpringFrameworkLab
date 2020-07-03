package org.example.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.domain.Task;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoSimple implements TaskDao {
    @Override
    public Task findById(int id) throws Exception {
        return new Task();
    }
    @Override
    public List<String[]> readAllTask(Reader reader) throws Exception {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}
