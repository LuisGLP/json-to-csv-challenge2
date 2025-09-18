package services;

import models.CityRecord;

import java.io.IOException;
import java.util.List;

public class ConverterService {

    private final JsonParserService jsonParserService = new JsonParserService();
    private final CsvWriterService csvWriterService = new CsvWriterService();

    public void convert(String inputJson, String outputCsv) throws IOException {
        List<CityRecord> cityRecords = jsonParserService.parseJson(inputJson);
        csvWriterService.writerToCsv(cityRecords, outputCsv);
    }
}
