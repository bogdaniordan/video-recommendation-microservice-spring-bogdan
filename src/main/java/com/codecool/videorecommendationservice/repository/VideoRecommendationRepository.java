package com.codecool.videorecommendationservice.repository;

import com.codecool.videorecommendationservice.entity.VideoRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendation, Long> {
}
