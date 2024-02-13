package com.rupesh.ratingservice.services.impl;

import com.rupesh.ratingservice.entities.Rating;
import com.rupesh.ratingservice.repositories.RatingRepository;
import com.rupesh.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        //        generated unique userid
//        String randomUserId = UUID.randomUUID().toString();
//        rating.setRatingId(randomUserId);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
