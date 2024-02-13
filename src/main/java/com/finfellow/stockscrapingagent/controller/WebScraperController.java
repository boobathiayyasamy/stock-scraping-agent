package com.finfellow.stockscrapingagent.controller;

import com.finfellow.stockscrapingagent.model.StockData;
import com.finfellow.stockscrapingagent.service.WebScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class WebScraperController {

    @Autowired
    private WebScraperService webScraperService;

    @GetMapping("/scrape")
    public List<StockData> scrape() throws IOException {
        return webScraperService.scrapeData();
    }
}

