import java.io.*;
import java.util.*;
public class SplitCSVByContinent
{
    public static void main(String[] args) {

            //Add path of your csv file
            String inputFile = "C:\\Users\\Ankita Gomkar\\Downloads\\export.csv";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine();

            String line;
            Map<String, BufferedWriter> continentWriters = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String continentIndex = parts[3];
                String outputFile = continentIndex + ".csv";

                // Check if writer for this continent already exists

                BufferedWriter writer = continentWriters.get(continentIndex);
                if (writer == null) {
                    writer = new BufferedWriter(new FileWriter(outputFile));
                    continentWriters.put(continentIndex, writer);
                }

                // Write the line to the corresponding file
                writer.write(line);
                writer.newLine();
            }

            // Close all writers
            for (BufferedWriter writer : continentWriters.values()) {
                writer.close();
            }

            System.out.println("CSV files split successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
