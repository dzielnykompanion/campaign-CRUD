package com.golabek.campaignapp.web;

import com.golabek.campaignapp.model.Campaign;
import com.golabek.campaignapp.service.CampaignService;
import com.golabek.campaignapp.service.ErrorMapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private ErrorMapValidationService errorMapValidationService;

    @PostMapping("/addCampaign/{sellerId}")
    public ResponseEntity<?> addOrUpdateCampaign(@Valid @RequestBody Campaign campaign,@PathVariable Long sellerId, BindingResult result) {

        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if ( errorMap != null ) return errorMap;

        campaignService.addOrUpdateCampaign(campaign, sellerId);
        return new ResponseEntity<Campaign>(campaign, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Campaign> campaigns = campaignService.getAll();
        return new ResponseEntity<List<Campaign>>(campaigns, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Campaign campaign = campaignService.findById(id);
        return new ResponseEntity<Campaign>(campaign, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteById(id);
        return new ResponseEntity<String>("Campaign with ID " + id + " has been deleted.", HttpStatus.OK);
    }


}
