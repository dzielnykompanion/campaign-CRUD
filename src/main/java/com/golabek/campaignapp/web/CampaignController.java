package com.golabek.campaignapp.web;

import com.golabek.campaignapp.model.Campaign;
import com.golabek.campaignapp.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignRepo campaignRepo;

    @PostMapping("/addCampaign")
    public ResponseEntity<?> addOrUpdateCampaign(@Valid @RequestBody Campaign campaign) {
        campaignRepo.save(campaign);
        return new ResponseEntity<Campaign>(campaign, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Campaign> campaigns = campaignRepo.findAll();
        return new ResponseEntity<List<Campaign>>(campaigns, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Campaign campaign = campaignRepo.findById(id).get();
        return new ResponseEntity<Campaign>(campaign, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable Long id) {
        campaignRepo.deleteById(id);
        return new ResponseEntity<String>("Campaign with ID " + id + " has been deleted.", HttpStatus.OK);
    }


}
