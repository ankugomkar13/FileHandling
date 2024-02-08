package org.example.write;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Assignment;
import org.example.utiles.FileWriter;

import java.io.File;
import java.util.List;

public class JsonFileWriter implements FileWriter
{
    @Override
    public void write(List<Assignment> list) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("Assignment.json"), list);
            System.out.println("File has been created.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
