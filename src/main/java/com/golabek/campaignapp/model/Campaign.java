package com.golabek.campaignapp.model;

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

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @ManyToMany
    private Set<Keyword> keywords;

    @NotNull
    private int bidAmount;

    @NotNull
    private int campaignFund;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Town town;

    @NotNull
    @Min(0)
    private int radius;

    public Campaign() {
    }

    public Campaign(@NotNull @NotBlank String name, @NotNull Set<Keyword> keywords, @NotNull int bidAmount, @NotNull int campaignFund, @NotNull Status status, Town town, @NotNull @Min(0) int radius) {
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.town = town;
        this.radius = radius;
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

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public int getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(int campaignFund) {
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }
}
