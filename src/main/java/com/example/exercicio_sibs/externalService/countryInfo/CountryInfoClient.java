package com.example.exercicio_sibs.externalService.countryInfo;

import com.example.exercicio_sibs.externalService.countryInfo.dto.CountryInfoDTO;
import com.example.exercicio_sibs.externalService.restCountries.dto.RestCountriesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Component
public class CountryInfoClient {
    private final WebClient webClient;

    @Value("${external.service.country.info.url}")
    String baseUrl;

    @Autowired
    public CountryInfoClient(WebClient.Builder webClientBuilder,
                                 @Value("${external.service.country.info.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    //@Async("taskExecutor")
    public CountryInfoDTO getCoutryInfo(String countryCode) {
        System.out.println("dentro getCoutryInfo");
        CountryInfoDTO result = new RestTemplate().getForObject(baseUrl + "/" + countryCode, CountryInfoDTO.class);

        return result;
       /* Mono<String> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);

        return response.toFuture();*/
    }

}
