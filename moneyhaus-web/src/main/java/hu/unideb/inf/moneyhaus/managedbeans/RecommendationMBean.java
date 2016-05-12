/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@RequestScoped
public class RecommendationMBean {

    @EJB
    CurrencyRateService currencyRateService;
    
    public List<String> recommendedCurrencies(){
        return currencyRateService.findTheBiggestGrowthCurrencies();
    }
    
}
