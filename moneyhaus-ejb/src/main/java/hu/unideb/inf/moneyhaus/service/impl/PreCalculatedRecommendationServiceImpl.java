/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.PreCalculatedRecommendationEntity;
import hu.unideb.inf.moneyhaus.repositories.PreCalculatedRecommendationDao;
import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.PreCalculatedRecommendationService;
import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * This class implements methods to calculate recommended currencies before any
 * user could request it. This enchances the speed of the service.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class PreCalculatedRecommendationServiceImpl implements PreCalculatedRecommendationService {

    /**
     * CurrencyRateService.
     */
    @EJB
    CurrencyRateService currencyRateService;
    /**
     * PreCalculatedRecommendationDao.
     */
    @Autowired
    PreCalculatedRecommendationDao preCalculatedRecommendationDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(PreCalculatedRecommendation preCalculatedRecommendation) {
        preCalculatedRecommendationDao.save(GenericConverter.mapTo(preCalculatedRecommendation, PreCalculatedRecommendationEntity.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PreCalculatedRecommendation> calculateRecommendations() {
        List<PreCalculatedRecommendation> result = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        final List<String> ALL = currencyRateService.getAllManagedCurrencies();
        for (String currencyCode : ALL) {
            Double average = currencyRateService.findAverageOfCurrencySinceDate(currencyCode, cal.getTime());
            CurrencyRateVO currencyRate = currencyRateService.findLatestCurrency(currencyCode);
            if (currencyRate == null) {
                continue;
            }
            if (currencyRate.getRate().divide(new BigDecimal((average)), RoundingMode.HALF_UP).compareTo(BigDecimal.ONE) > 0) {
                PreCalculatedRecommendation preCalculatedRecommendation = new PreCalculatedRecommendation();
                preCalculatedRecommendation.setGrowth(currencyRate.getRate().divide(new BigDecimal(average), RoundingMode.HALF_UP));
                preCalculatedRecommendation.setDate(new Date());
                preCalculatedRecommendation.setCurrency(currencyCode);
                result.add(preCalculatedRecommendation);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(List<PreCalculatedRecommendation> preCalculatedRecommendations) {
        preCalculatedRecommendationDao.save(GenericConverter.mapTo(preCalculatedRecommendations, PreCalculatedRecommendationEntity.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PreCalculatedRecommendation> getBiggestRecommendations() {
        List<PreCalculatedRecommendation> result = GenericConverter.mapTo(preCalculatedRecommendationDao.findLatestRecommendations(), PreCalculatedRecommendation.class);
        try {
            return result.subList(0, 5);
        } catch (Exception e) {
            return Collections.<PreCalculatedRecommendation>emptyList();
        }
    }
}
