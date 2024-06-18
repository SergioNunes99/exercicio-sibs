package com.example.exercicio_sibs.externalService.countryInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class CountryInfoClient {
    private final WebClient webClient;

    @Autowired
    public CountryInfoClient(WebClient.Builder webClientBuilder,
                                 @Value("${external.service.country.info.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Async("taskExecutor")
    public CompletableFuture<String> getCoutryInfo(String url) {
        Mono<String> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);

        return response.toFuture();
    }

}
