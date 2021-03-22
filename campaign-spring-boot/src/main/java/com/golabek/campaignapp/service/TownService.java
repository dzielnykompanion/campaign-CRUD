package com.golabek.campaignapp.service;

import com.golabek.campaignapp.model.Town;
import com.golabek.campaignapp.repository.TownRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownService {

    @Autowired
    TownRepo townRepo;

    public Town findById(Long id) throws Exception {
        try {
            Town town = townRepo.findById(id).get();
            return town;
        } catch (Exception ex){
            throw new Exception("Town with that ID doesnt exists");
        }
    }
}
