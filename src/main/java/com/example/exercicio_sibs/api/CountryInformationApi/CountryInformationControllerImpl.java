package com.example.exercicio_sibs.api.CountryInformationApi;

import com.example.exercicio_sibs.dto.CountryInformationDTO;
import com.example.exercicio_sibs.service.CountryInformation.CountryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class CountryInformationControllerImpl implements CountryInformationController{

    @Autowired
    private CountryInformationService countryInformationService;

    @Override
    public CountryInformationDTO getCountryInfo(String countryCode){
        return countryInformationService.getCoutryInfo(countryCode);
    }

    @Override
    public ResponseEntity<String> handleConversionFailedException(ConversionFailedException ex) {
        // You can customize the response based on the endpoint or any other logic
        return new ResponseEntity<>("Não existe nenhum país com o código especificado",
                HttpStatus.BAD_REQUEST);
    }
}
