package com.sorokaandriy.movie_streaming_service.controller;

import com.sorokaandriy.movie_streaming_service.service.MovieStreamService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/movies")
public class MovieStreamController {

    private final MovieStreamService service;

    public MovieStreamController(MovieStreamService service) {
        this.service = service;
    }

    @GetMapping("/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(service.streamVideo(videoPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
