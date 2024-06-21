package com.example.exercicio_sibs.api.CountryInformationApi;

import com.example.exercicio_sibs.dto.CountryInformationDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/countryInfo")
public interface CountryInformationController {

    @Operation(description = "Retorna informações sobre um dado país")
    @GetMapping(value = "/{countryCode}")
    CountryInformationDTO getCountryInfo(@PathVariable String countryCode);

    @ExceptionHandler(ConversionFailedException.class)
    ResponseEntity<String> handleConversionFailedException(ConversionFailedException ex);
}