/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.security.UserMBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.OwnedCurrencyService;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import java.io.Serializable;
import java.util.Date;
import javafx.event.ActionEvent;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@ViewScoped
public class CurrenciesMBean implements Serializable {

    Currency selected;

    public OwnedCurrency selectedEntity;

    @EJB
    CurrencyRateService currencyRateService;

    @EJB
    OwnedCurrencyService ownedCurrencyService;

    @ManagedProperty("#{userMBean}")
    UserMBean userMBean;

    public UserMBean getUserMBean() {
        return userMBean;
    }

    public Currency getSelected() {
        return selected;
    }

    public void setSelected(Currency selected) {
        this.selected = selected;
    }

    public void setSelectedEntity(OwnedCurrency selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public void setUserMBean(UserMBean userMBean) {
        this.userMBean = userMBean;
    }

    public List<String> getAllAvalibleCurrencies() {
        List<String> tmp = new ArrayList<>();
        for(Currency c : Currency.getAvailableCurrencies()){
            tmp.add(c.getCurrencyCode());
        }
        Collections.sort(tmp);
        return tmp;
    }

    public OwnedCurrency getSelectedEntity() {
        return selectedEntity;
    }

    public Date currentDate() {
        return new Date();
    }

    public void newEntity() {
        selectedEntity = new OwnedCurrency();
        selectedEntity.setDateOfBuy(new Date());
        selectedEntity.setUser(userMBean.getUser());
    }

    public List<OwnedCurrency> getUserCurrencies() {
        return ownedCurrencyService.findByUser(userMBean.getUser());
    }

    public void saveEntity(ActionEvent actionEvent){
        ownedCurrencyService.save(selectedEntity);
    }
    
}
