package services;

import models.CityRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterService {
    private static final  String[] HEADERS = {
            "name", "capital",  "population", "area", "currency", "languages", "region", "subregion", "flag"
    };

    public void writerToCsv(List<CityRecord> cityRecords, String outputFile) throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(outputFile),
                CSVFormat.DEFAULT.withHeader(HEADERS))) {

            for (CityRecord cityRecord : cityRecords) {

                printer.printRecord(
                        cityRecord.name(),
                        cityRecord.capital(),
                        cityRecord.population(),
                        cityRecord.area(),
                        cityRecord.currency(),
                        cityRecord.languages(),
                        cityRecord.region(),
                        cityRecord.subregion(),
                        cityRecord.flag()
                );
            }
        }
    }
}
