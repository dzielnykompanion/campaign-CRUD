package com.golabek.campaignapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.golabek.campaignapp.model.enums.Status;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank
    private String name;


    @ManyToMany
    private Set<Keyword> keywords;

    @NotNull(message = "Bid amount cannot be null")
    @Min(0)
    private Integer bidAmount;

    @NotNull(message = "Campaign fund cannot be null")
    @Min(0)
    private Integer campaignFund;

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Town town;

    @NotNull(message = "Radius cannot be null")
    @Min(0)
    private Integer radius;

    //@JsonBackReference
    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="seller_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellerId", nullable = false)
    private Seller seller;

    public Campaign() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(Integer campaignFund) {
        this.campaignFund = campaignFund;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @JsonIgnore
    public Seller getSeller() {
        return seller;
    }

    @JsonIgnore
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Long getSellerId(){
        return seller.getId();
    }

    public String getSellerName(){
        return seller.getName();
    }
}
