package com.example.demo195;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrickDao {
    @Autowired
    private BrickRepo brickRepo;

    List<Brick> findAll(){
        return brickRepo.findAll();
    }
}
