package com.sorokaandriy.movie_catalog_service.repository;

import com.sorokaandriy.movie_catalog_service.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {
}
