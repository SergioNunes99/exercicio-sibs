package com.example.exercicio_sibs.externalService.restCountries.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record RestCountriesResponseDTO(
        Name name,
        List<String> tld,
        String cca2,
        String ccn3,
        String cca3,
        String cioc,
        boolean independent,
        String status,
        boolean unMember,
        Map<String, Currency> currencies,
        IDD idd,
        List<String> capital,
        List<String> altSpellings,
        String region,
        String subregion,
        Map<String, String> languages,
        Map<String, Translation> translations,
        List<Double> latlng,
        boolean landlocked,
        List<String> borders,
        double area,
        Demonyms demonyms,
        String flag,
        MapLinks maps,
        long population,
        Gini gini,
        String fifa,
        Car car,
        List<String> timezones,
        List<String> continents,
        Flags flags,
        CoatOfArms coatOfArms,
        String startOfWeek,
        CapitalInfo capitalInfo,
        PostalCode postalCode
) {
    public record Name(
            String common,
            String official,
            Map<String, NativeName> nativeName
    ) {}

    public record NativeName(
            String official,
            String common
    ) {}

    public record Currency(
            String name,
            String symbol
    ) {}

    public record IDD(
            String root,
            List<String> suffixes
    ) {}

    public record Translation(
            String official,
            String common
    ) {}

    public record Demonyms(
            Eng eng,
            Fra fra
    ) {
        public record Eng(
                String f,
                String m
        ) {}

        public record Fra(
                String f,
                String m
        ) {}
    }

    public record MapLinks(
            String googleMaps,
            String openStreetMaps
    ) {}

    public record Gini(
            double _2018
    ) {}

    public record Car(
            List<String> signs,
            String side
    ) {}

    public record Flags(
            String png,
            String svg,
            String alt
    ) {}

    public record CoatOfArms(
            String png,
            String svg
    ) {}

    public record CapitalInfo(
            List<Double> latlng
    ) {}

    public record PostalCode(
            String format,
            String regex
    ) {}
}