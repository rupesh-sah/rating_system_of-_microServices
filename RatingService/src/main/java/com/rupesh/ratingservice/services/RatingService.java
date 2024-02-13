package com.rupesh.ratingservice.services;

import com.rupesh.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RatingService {
//    create
    Rating create(Rating rating);

//    get all rating

    List<Rating> getRating();
//    get all by UserId

    List<Rating> getRatingByUserId(String userId);

//    get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

}
