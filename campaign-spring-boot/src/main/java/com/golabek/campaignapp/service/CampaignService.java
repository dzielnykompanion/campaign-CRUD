package com.golabek.campaignapp.service;

import com.golabek.campaignapp.exceptions.CampaignIdException;
import com.golabek.campaignapp.exceptions.SellerFundsException;
import com.golabek.campaignapp.model.Campaign;
import com.golabek.campaignapp.model.Seller;
import com.golabek.campaignapp.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private SellerService sellerService;

    public Campaign addOrUpdateCampaign(Campaign campaign, Long sellerId){
        // will throw exception if not found
        Seller seller = sellerService.findById(sellerId);
        // when update, check if exists
        if ( campaign.getId() != null) {
            Campaign existingCampaign = findById(campaign.getId());
        }

        campaign.setSeller(seller);

        // check if seller has funds
        if (seller.getFunds() < campaign.getCampaignFund()){
            throw new SellerFundsException("Seller has not enough funds for this campaign");
        }

        // first save campaign
        campaignRepo.save(campaign);

        // then, update seller
        seller.setFunds(seller.getFunds()-campaign.getCampaignFund());
        seller.getCampaigns().add(campaign);
        sellerService.addOrUpdateSeller(seller);

        return campaign;
    }

    public List<Campaign> getAll(){
        return campaignRepo.findAll();
    }

    public Campaign findById(Long id){
        try {
            Campaign campaign = campaignRepo.findById(id).get();
            return campaign;
        } catch (Exception ex){
            throw new CampaignIdException("Campaign with ID " + id + " doesn't exist");
        }
    }

    public void deleteById(Long id){
        //check if exists
        Campaign existingCampaign = findById(id);

        campaignRepo.deleteById(id);
    }
}


