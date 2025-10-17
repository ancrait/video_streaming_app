package com.sorokaandriy.movie_streaming_service.service;

import com.sorokaandriy.movie_streaming_service.config.RestConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalogService {

    // name of service from application.properties
    private static final String CATALOG_SERVICE = "http://movie-catalog-service";
    private final RestTemplate restTemplate;

    public MovieCatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMoviePath(Long id){
        var response = restTemplate.getForEntity(CATALOG_SERVICE + "/movies-catalog/find-path-by-id/{id}", String.class, id);
        return response.getBody();
    }
}
