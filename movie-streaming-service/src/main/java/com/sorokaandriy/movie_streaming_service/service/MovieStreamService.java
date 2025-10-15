package com.sorokaandriy.movie_streaming_service.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class MovieStreamService {

    public InputStreamResource streamVideo(String videoPath) throws FileNotFoundException {
        File file = new File(videoPath);
        if (file.exists()){
            return new InputStreamResource(new FileInputStream(file));
        }
        throw new FileNotFoundException("File not found at this path");
    }
}
