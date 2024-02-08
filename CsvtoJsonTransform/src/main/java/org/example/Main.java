package org.example;
import org.example.Service.CsvConverter;
import org.example.write.JsonFileWriter;

public class Main {

    public static void main(String[] args) {

        CsvConverter file = new CsvConverter();
        file.generateJsonFile("C:\\Users\\Ankita Gomkar\\Downloads\\quesquestions.csv", "Assignment");

    }
}