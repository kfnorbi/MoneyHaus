/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service.impl;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.OwnedCurrenciesEntity;
import hu.unideb.inf.moneyhaus.entities.UserEntity;
import hu.unideb.inf.moneyhaus.repositories.OwnedCurrencyDao;
import hu.unideb.inf.moneyhaus.service.OwnedCurrencyService;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author Nolbelt
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OwnedCurrencyServiceImpl implements OwnedCurrencyService{
    
    @Autowired
    OwnedCurrencyDao ownedCurrencyDao;
    
    @Override
    public List<OwnedCurrency> findByUser(UserVO user){
        List<OwnedCurrenciesEntity> entities = ownedCurrencyDao.findByUser(GenericConverter.mapTo(user, UserEntity.class));
        return GenericConverter.mapTo(entities, OwnedCurrency.class);
    }

    @Override
    public void save(OwnedCurrency ownedCurrency) {
        ownedCurrencyDao.save(GenericConverter.mapTo(ownedCurrency, OwnedCurrenciesEntity.class));
    }

    @Override
    public void delete(OwnedCurrency ownedCurrency) {
        ownedCurrencyDao.delete(GenericConverter.mapTo(ownedCurrency, OwnedCurrenciesEntity.class));
    }
    
}
