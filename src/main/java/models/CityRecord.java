package models;

public record CityRecord(String name, String capital, int population, int area, String currency, String languages,
                         String region, String subregion, String flag) implements RecordType {}
