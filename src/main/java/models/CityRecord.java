package models;

/**
 * Represent a City record from the Json.
 * <p>
 *     Each record contains information about population, currency and flag.
 * </p>
 *
 * @param name Name of the city.
 * @param capital Capital of the city.
 * @param population Population of the city.
 * @param area Area of the city.
 * @param currency Currency of the city.
 * @param languages Languages of the city.
 * @param region Region where is located.
 * @param subregion Subregion where is located.
 * @param flag Flag of the country.
 */

public record CityRecord(String name, String capital, int population, int area, String currency, String languages,
                         String region, String subregion, String flag) implements RecordType {}
