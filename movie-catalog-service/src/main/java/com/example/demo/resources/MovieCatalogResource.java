package com.example.demo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CatalogItem;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;
import com.example.demo.service.MovieInfo;
import com.example.demo.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")

public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingInfo;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@GetMapping("/{userId}")
	List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId) {

		UserRating ratingsList = userRatingInfo.getRating(userId);

		return ratingsList.getUserRating().stream().map(ratings -> 
			movieInfo.getCatalogItem(ratings))
			.collect(Collectors.toList());

//			 using webClientBuilder
			/*
			 * Movie movie =webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movies/" + ratings.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */


	


	}

	

	
}
