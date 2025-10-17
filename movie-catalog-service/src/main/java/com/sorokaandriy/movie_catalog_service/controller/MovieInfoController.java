package com.sorokaandriy.movie_catalog_service.controller;

import com.sorokaandriy.movie_catalog_service.model.MovieInfo;
import com.sorokaandriy.movie_catalog_service.repository.MovieInfoRepository;
import com.sorokaandriy.movie_catalog_service.service.MovieInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies-catalog")
public class MovieInfoController {

    private final MovieInfoService service;
    private final MovieInfoRepository repository;

    public MovieInfoController(MovieInfoService service, MovieInfoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<List<MovieInfo>> saveAll(@RequestBody List<MovieInfo> movieInfoList){
        return ResponseEntity.ok(repository.saveAll(movieInfoList));
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieInfo>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/find-path-by-id/{id}")
    public ResponseEntity<String> findMoviePathById(@PathVariable Long id){
        return ResponseEntity.ok(service.findMoviePathById(id));
    }
}
