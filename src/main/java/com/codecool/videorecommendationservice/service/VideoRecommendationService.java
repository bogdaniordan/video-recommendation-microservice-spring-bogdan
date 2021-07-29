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
         log.info("Fetching a video recommendation with id: " + id);
        return videoRecommendationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find a video recommendation with id: " + id));
    }

    public VideoRecommendation updateRecommendation(VideoRecommendation newVideoRecommendation, Long id) {
        log.info("Updating video recommendation with id: " + id);
        VideoRecommendation videoRecommendation = videoRecommendationRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Could not find recommendation with id: " + id));
        videoRecommendation.setRating(newVideoRecommendation.getRating());
        videoRecommendation.setComment(newVideoRecommendation.getComment());
        videoRecommendation.setVideoId(newVideoRecommendation.getVideoId());
        videoRecommendation.setDate(newVideoRecommendation.getDate());
        return videoRecommendationRepository.save(videoRecommendation);
    }

    public VideoRecommendation saveVideoRecommendation(VideoRecommendation videoRecommendation, Long videoId) {
        videoRecommendation.setVideoId(videoId);
        return videoRecommendationRepository.save(videoRecommendation);
    }

    public List<VideoRecommendation> getRecommendationByVideoId(Long videoId) {
        return videoRecommendationRepository.getVideoRecommendationsByVideoId(videoId)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
