package com.example.exercicio_sibs.service.CountryInformation;

import com.example.exercicio_sibs.dto.CountryInformationDTO;

public interface CountryInformationService {
    /**
     * Returns information from a specific country, originating from various api's
     * @param countryCode code from the country that we want to fetch information
     */
    CountryInformationDTO getCoutryInfo(String countryCode);
}
