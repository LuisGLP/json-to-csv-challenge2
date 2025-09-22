package services;

import models.CityRecord;

import java.io.IOException;
import java.util.List;

/**
 * Service class responsible for loading a JSON into a list of city records
 * and sending the list to the {@link CsvWriterService} to writing into a CSV file.
 * <p>
 *     This class uses the services {@link JsonParserService} and {@link CsvWriterService}.
 * </p>
 *
 * @author Luis
 * @version 0.1
 */

public class ConverterService {

    private final JsonParserService jsonParserService = new JsonParserService();
    private final CsvWriterService csvWriterService = new CsvWriterService();

    /**
     * Uses a {@link JsonParserService} to loads a JSON and use {@link CsvWriterService} to writing into a CSV.
     *
     * @param inputJson Path to the JSON file.
     * @param outputCsv Path where the CSV file will be created.
     * @param delimiter Delimiter to use in the CSV (e.g., "," or ";").
     * @throws IOException if an error occurs while reading the JSON or writing the CSV.
     */

    public void convert(String inputJson, String outputCsv, String delimiter) throws IOException {
        List<CityRecord> cityRecords = jsonParserService.parseJson(inputJson);
        csvWriterService.writerToCsv(cityRecords, outputCsv, delimiter);
    }
}
