package services;

import models.CityRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.RecordComponent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service class responsible for load Json File.
 * <p>
 *     This class uses json.org to parse and manipulate Json.
 * </p>
 *
 * @author Luis
 * @version 0.1
 */

public class JsonParserService {
    /**
     * Loads a list of {@link CityRecord}.
     *
     * @param filePath Path to the JSON file.
     * @throws IOException if an error occurs while loading the file.
     * @return cityRecords list of records.
     */

    public List<CityRecord> parseJson(String filePath) throws IOException {

        String content = Files.readString(Paths.get(filePath));
        JSONArray jsonArray = new JSONArray(content);
        List<CityRecord> cityRecords = new ArrayList<>();
        RecordComponent[] components = CityRecord.class.getRecordComponents();
        Set<String> recordNames = new HashSet<>();

        for (RecordComponent recordComponent : components) {
            recordNames.add(recordComponent.getName());
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            Set<String> jsonKeys = object.keySet();
            for (String name : recordNames) {
                if (!jsonKeys.contains(name)) {
                    throw new IllegalStateException(
                            "Missing key in Json object at index: " + i + ":  " + name
                    );
                }
            }

            CityRecord record = new CityRecord(
                    object.optString("name"),
                    object.optString("capital"),
                    object.optInt("population"),
                    object.optInt("area"),
                    object.optString("currency"),
                    object.optString("languages"),
                    object.optString("region"),
                    object.optString("subregion"),
                    object.optString("flag")
            );
            cityRecords.add(record);
        }
        return cityRecords;
    }
}
