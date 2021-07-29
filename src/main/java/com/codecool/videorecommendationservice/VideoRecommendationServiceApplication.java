package com.codecool.videorecommendationservice;

import com.codecool.videorecommendationservice.entity.VideoRecommendation;
import com.codecool.videorecommendationservice.repository.VideoRecommendationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class VideoRecommendationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoRecommendationServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(VideoRecommendationRepository repository) {
		return args -> {
			repository.save(new VideoRecommendation(1L, 3, "magnificent", 1L, LocalDate.of(2002, 11, 1)));
			repository.save(new VideoRecommendation(2L, 3, "pretty", 1L, LocalDate.of(2002, 11, 2)));
			repository.save(new VideoRecommendation(3L, 3, "nice", 1L, LocalDate.of(2002, 11, 3)));
			repository.save(new VideoRecommendation(4L, 3, "bad", 2L, LocalDate.of(2002, 11, 4)));
			repository.save(new VideoRecommendation(5L, 3, "ugly", 2L, LocalDate.of(2002, 11, 5)));
			repository.save(new VideoRecommendation(6L, 3, "weak", 2L, LocalDate.of(2002, 11, 6)));
			repository.save(new VideoRecommendation(7L, 3, "so and so", 3L, LocalDate.of(2002, 11, 7)));
			repository.save(new VideoRecommendation(8L, 3, "masterpiece", 3L, LocalDate.of(2002, 11, 8)));
			repository.save(new VideoRecommendation(9L, 3, "all right", 3L, LocalDate.of(2002, 11, 9)));
		};
	}

}
