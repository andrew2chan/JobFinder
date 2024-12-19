package com.andrew2chan.job_finder.service;

import com.andrew2chan.job_finder.domain.Listing;
import com.andrew2chan.job_finder.domain.RespondentInputs;
import org.jsoup.nodes.Document;

import java.util.List;

public interface MainService {
    public List<Listing> retrieveDataFromWebsite(RespondentInputs inputs);
    public Document retrieveDocumentFromWebsite(String url);
}
