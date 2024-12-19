package com.andrew2chan.job_finder.controller;

import com.andrew2chan.job_finder.domain.Listing;
import com.andrew2chan.job_finder.domain.RespondentInputs;
import com.andrew2chan.job_finder.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Main {
    private MainService mainService;

    public Main(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/getListings")
    public ResponseEntity<List<Listing>> getListings(@RequestBody RespondentInputs inputs) {
        List<Listing> dataRetrieve = mainService.retrieveDataFromWebsite(inputs);

        if(dataRetrieve.isEmpty()) new ResponseEntity<>(dataRetrieve, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(dataRetrieve, HttpStatus.OK);
    }
}