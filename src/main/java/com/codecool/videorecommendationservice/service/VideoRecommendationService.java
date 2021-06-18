package com.codecool.videorecommendationservice.service;

import com.codecool.videorecommendationservice.entity.VideoRecommendation;
import com.codecool.videorecommendationservice.repository.VideoRecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VideoRecommendationService {

    @Autowired
    private VideoRecommendationRepository videoRecommendationRepository;

    public List<VideoRecommendation> getAllRecommendations() {
         log.info("Fetching all video recommendations.");
        return videoRecommendationRepository.findAll();
    }

    public VideoRecommendation getVideoRecommendationById(Long id) {
         log.info("Fetching a video recommendation.");
        return videoRecommendationRepository.findById(id).get();
    }

    public VideoRecommendation updateRecommendation(VideoRecommendation newVideoRecommendation) {
        log.info("Updating video recommendation.");
        if (videoRecommendationRepository.findById(newVideoRecommendation.getId()).isPresent()) {
            VideoRecommendation videoRecommendation = videoRecommendationRepository.findById(newVideoRecommendation.getId()).get();
            videoRecommendation.setRating(newVideoRecommendation.getRating());
            videoRecommendation.setComment(newVideoRecommendation.getComment());
            videoRecommendation.setVideoId(newVideoRecommendation.getVideoId());
            videoRecommendationRepository.save(videoRecommendation);
            return videoRecommendation;
        }
        return null;
    }

    public VideoRecommendation saveVideoRecommendation(VideoRecommendation videoRecommendation) {
        return videoRecommendationRepository.save(videoRecommendation);
    }
}
