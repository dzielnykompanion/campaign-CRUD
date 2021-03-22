package com.golabek.campaignapp.web;

import com.golabek.campaignapp.model.Seller;
import com.golabek.campaignapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/addSeller")
    public ResponseEntity<?> addOrUpdateCampaign(@Valid @RequestBody Seller seller) {

        sellerService.addOrUpdateSeller(seller);
        return new ResponseEntity<Seller>(seller, HttpStatus.CREATED);
    }

    @GetMapping("/seller/getAll")
    public ResponseEntity<?> getAll() {
        List<Seller> sellers = sellerService.getAll();
        return new ResponseEntity<List<Seller>>(sellers, HttpStatus.OK);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Seller seller = sellerService.findById(id);
        return new ResponseEntity<Seller>(seller, HttpStatus.OK);
    }
}
