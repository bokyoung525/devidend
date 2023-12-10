package com.zerobase.devidend.service;

import com.zerobase.devidend.exception.impl.NoCompanyException;
import com.zerobase.devidend.model.Company;
import com.zerobase.devidend.model.Dividend;
import com.zerobase.devidend.model.ScrapedResult;
import com.zerobase.devidend.model.constants.CacheKey;
import com.zerobase.devidend.persist.CompanyRepository;
import com.zerobase.devidend.persist.DividendRepository;
import com.zerobase.devidend.persist.entity.CompanyEntity;
import com.zerobase.devidend.persist.entity.DividendEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {
    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    @Cacheable(key = "#companyName", value = CacheKey.KEY_FINANCE)
    public ScrapedResult getDividendByCompanyName(String companyName) {
        log.info("search company -> " + companyName);

        CompanyEntity company = this.companyRepository.findByName(companyName)
                .orElseThrow(() -> new NoCompanyException());

        List<DividendEntity> dividendEntities = this.dividendRepository.findAllByCompanyId(company.getId());

        List<Dividend> dividends = dividendEntities.stream()
                .map(e -> new Dividend(e.getDate(), e.getDividend()))
                .collect(Collectors.toList());

        return new ScrapedResult(new Company(company.getTicker(), company.getName()),
                dividends);
    }
}
