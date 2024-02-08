package org.example.read;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.utiles.Fileread;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileReader implements Fileread {

    @Override
    public List<String[]> read(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = reader.readAll();
            return csvData;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
