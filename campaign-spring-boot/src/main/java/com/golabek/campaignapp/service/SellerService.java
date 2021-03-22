package com.golabek.campaignapp.service;

import com.golabek.campaignapp.exceptions.SellerIdException;
import com.golabek.campaignapp.model.Seller;
import com.golabek.campaignapp.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepo sellerRepo;

    public Seller addOrUpdateSeller(Seller seller) {
        // when update, check if exists
        if (seller.getId() != null) {
            Seller existingSeller = findById(seller.getId());
        }
        return sellerRepo.save(seller);
    }

    public Seller findById(Long id){
        try {
            Seller seller = sellerRepo.findById(id).get();
            return seller;
        } catch (Exception ex){
            throw new SellerIdException("Seller with ID " + id + " doesn't exist");
        }
    }

    public List<Seller> getAll(){
        return sellerRepo.findAll();
    }

}
