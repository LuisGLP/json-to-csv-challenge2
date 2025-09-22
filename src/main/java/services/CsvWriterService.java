package services;

import models.CityRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;

/**
 * Service class responsible for writing data into CSV file.
 * <p>
 *     This class uses apache commons CSV to generate CSV file
 *     with dynamic headers obtained from the model.
 * </p>
 *
 * @author Luis
 * @version 0.1
 */

public class CsvWriterService {

    /**
     * Writes a list of {@link CityRecord} into a CSV file.
     *
     * @param cityRecords List of cities records to be written.
     * @param outputFile Path where the CSV file will be created.
     * @param delimiter To separate the columns of the record.
     * @throws IOException If there is an error while writing the file.
     * @throws IllegalArgumentException If the record list is empty.
     */

    public void writerToCsv(List<CityRecord> cityRecords, String outputFile, String delimiter) throws IOException {
        if (cityRecords.isEmpty()) {
            throw new IllegalArgumentException("City records cannot be empty");
        }

        RecordComponent[] components = CityRecord.class.getRecordComponents();
        String[] recordHeaders = Arrays.stream(components)
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        System.out.println("Validating headers...");
        System.out.println("Record headers: " + String.join(delimiter, recordHeaders));

        try (CSVPrinter printer = new CSVPrinter(new FileWriter(outputFile),
                CSVFormat.Builder
                        .create()
                        .setHeader(recordHeaders)
                        .setDelimiter(delimiter)
                        .build())) {
            for (CityRecord record : cityRecords) {
                Object[] values = new Object[components.length];
                for (int i = 0; i < components.length; i++) {
                    try {
                        values[i] = components[i].getAccessor().invoke(record);
                    } catch (Exception e) {
                        values[i] = "";
                    }
                }
                printer.printRecord(values);
            }
        }
    }
}
