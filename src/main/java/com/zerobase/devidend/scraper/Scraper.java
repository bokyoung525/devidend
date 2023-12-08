package com.zerobase.devidend.scraper;

import com.zerobase.devidend.model.Company;
import com.zerobase.devidend.model.ScrapedResult;

public interface Scraper {
    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}
