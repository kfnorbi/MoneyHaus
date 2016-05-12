/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.List;

/**
 *
 * @author Nolbelt
 */
public interface OwnedCurrencyService {
    
    public List<OwnedCurrency> findByUser(UserVO user);
    
    public void save(OwnedCurrency ownedCurrency);
    
    public void delete(OwnedCurrency ownedCurrency);
    
}
