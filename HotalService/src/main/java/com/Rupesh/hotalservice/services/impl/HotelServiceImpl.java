package com.Rupesh.hotalservice.services.impl;

import com.Rupesh.hotalservice.entites.Hotel;
import com.Rupesh.hotalservice.exceptions.ResourceNotFoundException;
import com.Rupesh.hotalservice.repositories.HotelRepository;
import com.Rupesh.hotalservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveUser(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllUser() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getUser(String userId) {
        return hotelRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Hotel user with given id is not found on server !!"+userId));
    }
}
