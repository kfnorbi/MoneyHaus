/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.refresher;

import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface SupportedCurrenciesService{
    
    public List<String> getSupportedCurrencies();
    
    public void refreshSupportedCurrencies();
    
}
