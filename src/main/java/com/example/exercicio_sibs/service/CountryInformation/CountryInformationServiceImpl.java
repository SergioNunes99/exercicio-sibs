package com.example.exercicio_sibs.service.CountryInformation;

import com.example.exercicio_sibs.dto.CountryInformationDTO;
import com.example.exercicio_sibs.externalService.countryInfo.CountryInfoClient;
import com.example.exercicio_sibs.externalService.countryInfo.dto.CountryInfoDTO;
import com.example.exercicio_sibs.externalService.restCountries.RestCountriesClient;
import com.example.exercicio_sibs.externalService.restCountries.dto.RestCountriesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class CountryInformationServiceImpl implements CountryInformationService{

    @Autowired
    private RestCountriesClient restCountriesClient;

    @Autowired
    private CountryInfoClient countryInfoClient;

    @Override
    public CountryInformationDTO getCoutryInfo(String countryCode){
        CompletableFuture<CountryInfoDTO> futureRestCountry =
                CompletableFuture.supplyAsync(() -> countryInfoClient.getCoutryInfo(countryCode));

        futureRestCountry.thenAccept((result) -> {
            System.out.println("Acabou pedido");
            System.out.println(result);
        });

        futureRestCountry.exceptionally(throwable -> {
            System.out.println("ERRRRRRO!! " + throwable);
            return null;
        });

        try {
            CountryInfoDTO r = futureRestCountry.join();

            System.out.println("dentro fo try : " + r);
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("Retorna main function!");

        return new CountryInformationDTO(new Date().toString(), null);
    }
}
