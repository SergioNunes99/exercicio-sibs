package com.example.exercicio_sibs.dto;

import com.example.exercicio_sibs.service.CountryInformation.CountryInformationService;

public record CountryInformationDTO(String officialLanguage,
                                    Long population,
                                    String currency,
                                    String capital,
                                    String airportICAO,
                                    String lat,
                                    String lng){
    public CountryInformationDTO(String capital, Long population){
        this(null, population, null, capital, null, null, null);
    }

}
