package com.andrew2chan.job_finder.service.Impl;

import com.andrew2chan.job_finder.domain.Listing;
import com.andrew2chan.job_finder.domain.RespondentInputs;
import com.andrew2chan.job_finder.service.MainService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Override
    public List<Listing> retrieveDataFromWebsite(RespondentInputs inputs) {
        List<Listing> data = new ArrayList<>();

        try {
            Document document = retrieveDocumentFromWebsite("https://en.wikipedia.org/");
            Elements newsHeadlines = document.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title") + " " +  headline.absUrl("href"));
            }
        }
        catch(Exception e) {
            return data;
        }

        return data;
    }

    @Override
    public Document retrieveDocumentFromWebsite(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
