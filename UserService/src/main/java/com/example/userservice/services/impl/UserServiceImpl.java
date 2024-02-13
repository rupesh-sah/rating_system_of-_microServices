package com.example.userservice.services.impl;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.ResourceNotFoundException;
//import com.example.userservice.external.services.HotelService;
import com.example.userservice.repositories.UserRepository;
import com.example.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
//        generated unique userid
//        String randomUserId = UUID.randomUUID().toString();
//        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user =  userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with given id is not found on server !!"+userId));
// fetch rating of the above user from RATING service
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
//            api call to hotel service to get the hotel
            System.out.println(rating.getHotelId());
            ResponseEntity<Hotel> forEntity = restTemplate. getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();

            logger.info("response status code : {}", forEntity.getStatusCode());
//            set the hotel to rating
            rating.setHotel(hotel);
//            return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);

        return user;
    }
}
