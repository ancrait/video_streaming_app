package com.sorokaandriy.movie_catalog_service.controller;

import com.sorokaandriy.movie_catalog_service.model.MovieInfo;
import com.sorokaandriy.movie_catalog_service.repository.MovieInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//"C:\\Users\\D\\Videos\\NVIDIA\\The Witcher 3\\The Witcher 3 2024.12.09 - 00.19.32.01.mp4"
//"C:\\Users\\D\\Videos\\NVIDIA\\The Witcher 2  Assassins of Kings\\The Witcher 2  Assassins of Kings 2025.08.11 - 16.23.48.01.mp4"
//"C:\\Users\\D\\Videos\\NVIDIA\\World of Tanks Blitz\\World of Tanks Blitz 2024.12.02 - 16.24.05.01.mp4"
//"C:\\Users\\D\\Videos\\NVIDIA\\The Last of Us™ Part II Remastered\\The Last of Us™ Part II Remastered 2025.04.19 - 00.12.27.01.mp4"


@RestController
@RequestMapping("/movies-catalog")
public class MovieInfoController {

    private final MovieInfoRepository repository;

    public MovieInfoController(MovieInfoRepository repository) {
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
}
