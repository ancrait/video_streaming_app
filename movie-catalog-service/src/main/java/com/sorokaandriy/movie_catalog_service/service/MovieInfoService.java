package com.sorokaandriy.movie_catalog_service.service;

import com.sorokaandriy.movie_catalog_service.model.MovieInfo;
import com.sorokaandriy.movie_catalog_service.repository.MovieInfoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieInfoService {

    private final MovieInfoRepository repository;

    public MovieInfoService(MovieInfoRepository repository) {
        this.repository = repository;
    }

    public String findMoviePathById(Long id){
        Optional<MovieInfo> optional = repository.findById(id);
        if (optional.isPresent()){
            return optional.get().getPath();
        }
        throw new NoSuchElementException("Cant find movie with " + id);
    }
}
