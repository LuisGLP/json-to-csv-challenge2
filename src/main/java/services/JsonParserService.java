package services;

import models.CityRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParserService {
    public List<CityRecord> parseJson(String filePath) throws IOException {
        String content = Files.readString(Paths.get(filePath));

        JSONArray jsonArray = new JSONArray(content);
        List<CityRecord> cityRecords = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);

            CityRecord record = new CityRecord(
                    jsonObject.optString("name"),
                    jsonObject.optString("capital"),
                    jsonObject.optInt("population"),
                    jsonObject.optInt("area"),
                    jsonObject.optString("currency"),
                    jsonObject.optString("languages"),
                    jsonObject.optString("region"),
                    jsonObject.optString("subregion"),
                    jsonObject.optString("flag")
            );
            cityRecords.add(record);
        }
        return cityRecords;
    }
}
