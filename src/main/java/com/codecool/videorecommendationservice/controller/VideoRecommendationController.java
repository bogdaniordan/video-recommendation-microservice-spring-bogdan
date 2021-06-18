package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.entity.VideoRecommendation;
import com.codecool.videorecommendationservice.service.VideoRecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video-recommendations")
@Slf4j
public class VideoRecommendationController {

    @Autowired
    private VideoRecommendationService videoRecommendationService;

    @GetMapping("")
    public List<VideoRecommendation> getAllRecommendations() {
        return videoRecommendationService.getAllRecommendations();
    }

    @GetMapping("/{id}")
    public VideoRecommendation getVideoRecommendation(@PathVariable Long id) {
        log.info("Getting video recommendation with id: " + id);
        return videoRecommendationService.getVideoRecommendationById(id);
    }

    @PutMapping("")
    public VideoRecommendation updateVideoRecommendation(@RequestBody VideoRecommendation videoRecommendation) {
        return videoRecommendationService.updateRecommendation(videoRecommendation);
    }

    @PostMapping("")
    public VideoRecommendation saveNewRecommendation(@RequestBody VideoRecommendation videoRecommendation) {
        return videoRecommendationService.saveVideoRecommendation(videoRecommendation);
    }
}
