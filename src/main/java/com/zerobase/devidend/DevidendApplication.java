package com.zerobase.devidend;

import com.zerobase.devidend.model.Company;
import com.zerobase.devidend.scraper.YahooFinanceScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;


@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DevidendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevidendApplication.class, args);


    }

}
