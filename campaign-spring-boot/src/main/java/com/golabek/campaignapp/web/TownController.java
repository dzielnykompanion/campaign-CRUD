package com.golabek.campaignapp.web;

import com.golabek.campaignapp.model.Town;
import com.golabek.campaignapp.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TownController {

    @Autowired
    TownService townService;

    @GetMapping("/town/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        Town town = townService.findById(id);
        return new ResponseEntity<Town>(town, HttpStatus.OK);
    }
}
