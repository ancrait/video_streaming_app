package com.sorokaandriy.movie_streaming_service.controller;

import com.sorokaandriy.movie_streaming_service.service.MovieCatalogService;
import com.sorokaandriy.movie_streaming_service.service.MovieStreamService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;



@RestController
@RequestMapping("/movies")
public class MovieStreamController {

    public final static String DIRECTORY = "C:\\Users\\D\\Videos\\NVIDIA\\";

    private final MovieStreamService service;
    private final MovieCatalogService catalogService;

    public MovieStreamController(MovieStreamService service, MovieCatalogService catalogService) {
        this.service = service;
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<InputStreamResource> streamVideo(@RequestParam("videoPath") String videoPath) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(service.streamVideo(DIRECTORY + videoPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> streamVideoById(@PathVariable Long id) {
        String path = catalogService.getMoviePath(id);
        return streamVideo(path);
    }

}
