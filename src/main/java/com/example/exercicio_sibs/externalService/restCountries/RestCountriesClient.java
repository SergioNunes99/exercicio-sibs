package com.example.exercicio_sibs.externalService.restCountries;

import com.example.exercicio_sibs.externalService.restCountries.dto.RestCountriesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Component
public class RestCountriesClient {

    private final WebClient webClient;

    @Value("${external.service.rest.country.url}")
    String baseUrl;

    @Autowired
    public RestCountriesClient(WebClient.Builder webClientBuilder,
                             @Value("${external.service.rest.country.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    //@Async("taskExecutor")
    public RestCountriesResponseDTO getCoutryInfo(String countryCode) {
        System.out.println("entrou getCoutryInfo");
        RestCountriesResponseDTO result = new RestTemplate().getForObject(baseUrl + "/" + countryCode, RestCountriesResponseDTO.class);
        System.out.println("resultado getCoutryInfo ----> " + result);

        return result;
       /* Mono<RestCountriesResponseDTO> response = webClient.get()
                .uri("/" + countryCode)
                .retrieve()
                .bodyToMono(RestCountriesResponseDTO.class);

        return response.block();*/
    }
}
