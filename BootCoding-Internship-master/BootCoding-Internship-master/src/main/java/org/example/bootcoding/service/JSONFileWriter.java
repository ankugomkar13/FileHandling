package org.example.bootcoding.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bootcoding.model.Assignment;
import org.example.bootcoding.utils.FileWriterInterface;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONFileWriter implements FileWriterInterface {
    @Override
    public void write(List<Assignment> list,String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), list);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
