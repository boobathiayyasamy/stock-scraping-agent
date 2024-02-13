package com.finfellow.stockscrapingagent.service;

import com.finfellow.stockscrapingagent.model.StockData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScraperService {

    private static final Logger logger = LoggerFactory.getLogger(WebScraperService.class);

    public List<StockData> scrapeData() throws IOException {
        logger.debug("Inside scrapeData()");
        List<StockData> companyDataList = new ArrayList<>();

        // URL to scrape
        String url = "https://ticker.finology.in/market/52-week-low";

        // Fetch the HTML content from the URL
        Document doc = Jsoup.connect(url).get();
        logger.debug("Post Jsoup()");

        // Select the specific div by its id
        Element divElement = doc.getElementById("mainContent_pnlhighlow");
        Elements rows = divElement.select("tbody > tr");
        logger.debug(rows.toString());

        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() >= 4) {
                String companyName = columns.get(1).text();
                String price = columns.get(2).text();
                String dayLow = columns.get(3).text();

                // Create CompanyData object and add it to the list
                companyDataList.add(new StockData(companyName, price, dayLow));
            }
        }
        return companyDataList;
    }
}

