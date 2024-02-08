package org.example.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.read.CsvFileReader;

import java.io.File;
import java.util.List;

public class CsvConverter {
    private final CsvFileReader fileReader = new CsvFileReader();
    private final ObjectMapper mapper = new ObjectMapper();

    public String generateJsonFile(String filepath, String outputFileName) {
        List<String[]> csvData = fileReader.read(filepath);
        if (csvData != null && !csvData.isEmpty()) {
            String[] headers = csvData.get(0); // Assuming first row contains headers
            ArrayNode jsonArray = mapper.createArrayNode();

            for (int i = 1; i < csvData.size(); i++) {
                String[] values = csvData.get(i);
                ObjectNode jsonObject = mapper.createObjectNode();
                for (int j = 0; j < headers.length && j < values.length; j++) {
                    jsonObject.put(headers[j], values[j]);
                }
                jsonArray.add(jsonObject);
            }

            // Write JSON array to file
            try {
                mapper.writeValue(new File(outputFileName), jsonArray);
                return "JSON file generated successfully.";
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed to generate JSON file.";
            }
        } else {
            return "Empty or null csvData.";
        }
  }
}
