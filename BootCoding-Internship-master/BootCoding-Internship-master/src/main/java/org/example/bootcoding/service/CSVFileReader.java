package org.example.bootcoding.service;

import org.example.bootcoding.utils.FileReaderInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements FileReaderInterface {
    public List<String> read(String csvFile) {
        List<String> recordData = new ArrayList<>();
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();
            while ((line = reader.readLine())  != null){
                recordData.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordData;
    }
}
