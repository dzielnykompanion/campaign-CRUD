package com.golabek.campaignapp.service;

import com.golabek.campaignapp.model.Keyword;
import com.golabek.campaignapp.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {

    @Autowired
    KeywordRepo keywordRepo;

    public Keyword findById(Long id) throws Exception {
        try {
            Keyword keyword = keywordRepo.findById(id).get();
            return keyword;
        } catch (Exception ex){
            throw new Exception("Keyword with that ID doesnt exists");
        }
    }
}
