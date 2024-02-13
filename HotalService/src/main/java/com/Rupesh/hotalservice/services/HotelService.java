package com.Rupesh.hotalservice.services;

import com.Rupesh.hotalservice.entites.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HotelService {

    //    create
    Hotel saveUser(Hotel hotel);

    //    get all user
    List<Hotel> getAllUser();

    //    get a single user of given userId
    Hotel getUser(String userId);
}
