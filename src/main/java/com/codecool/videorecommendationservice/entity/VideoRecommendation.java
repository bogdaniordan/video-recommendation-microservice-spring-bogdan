package com.codecool.videorecommendationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rating;
    private String comment;
    private Long videoId;
}
