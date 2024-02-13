package com.Rupesh.hotalservice.controllers;

import com.Rupesh.hotalservice.entites.Hotel;
import com.Rupesh.hotalservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
//    create
    @PostMapping
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.saveUser(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
//    get single user
    @GetMapping("/{userId}")
    public ResponseEntity<Hotel> getSingleUser(@PathVariable String userId){
        Hotel hotel = hotelService.getUser(userId);
        return ResponseEntity.ok(hotel);
    }
//     get all user data
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllUser(){
        List<Hotel> allUser = hotelService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
