package com.example.exercicio_sibs.externalService.countryInfo.dto;

import java.util.List;
import java.util.Map;

public record CountryInfoDTO(
        String name,
        List<String> tld,
        String cca2,
        String ccn3,
        String cca3,
        String cioc,
        String fifa,
        boolean independent,
        String status,
        boolean unMember,
        Map<String, Currency> currencies,
        String callingcode,
        List<String> capital,
        List<String> altSpellings,
        String region,
        String subregion,
        List<String> continents,
        Map<String, String> languages,
        List<Double> latlng,
        boolean landlocked,
        List<String> borders,
        double area,
        String flag,
        String coatOfArms,
        long population,
        MapLinks maps,
        Car car,
        String postalCodeFormat,
        String startOfWeek,
        List<String> timezones
) {
    public record Currency(
            String name,
            String symbol
    ) {}

    public record MapLinks(
            String googleMaps,
            String openStreetMaps
    ) {}

    public record Car(
            List<String> signs,
            String side
    ) {}
}
