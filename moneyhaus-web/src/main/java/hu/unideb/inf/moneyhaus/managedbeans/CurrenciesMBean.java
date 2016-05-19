/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.security.UserMBean;
import java.util.Currency;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import hu.unideb.inf.moneyhaus.service.CurrencyRateService;
import hu.unideb.inf.moneyhaus.service.OwnedCurrencyService;
import hu.unideb.inf.moneyhaus.service.CurrencyBaseConverter;
import hu.unideb.inf.moneyhaus.service.PreCalculatedRecommendationService;
import hu.unideb.inf.moneyhaus.service.exception.NoCurrencyDataException;
import hu.unideb.inf.moneyhaus.vo.OwnedCurrency;
import hu.unideb.inf.moneyhaus.vo.PreCalculatedRecommendation;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@SessionScoped
public class CurrenciesMBean implements Serializable {

    Currency selected;

    String showOffCurrencyCode = "GBP";

    private OwnedCurrency selectedEntity;

    @EJB
    CurrencyRateService currencyRateService;

    @EJB
    OwnedCurrencyService ownedCurrencyService;

    @EJB
    CurrencyBaseConverter currencyBaseConverter;

    @EJB
    PreCalculatedRecommendationService preCalculatedRecommendationService;

    @ManagedProperty("#{userMBean}")
    UserMBean userMBean;

    @PostConstruct
    public void init() {
//        newEntity();
    }

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
        return currencyRateService.getAllManagedCurrencies();
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

    public void saveEntity() {
        ownedCurrencyService.save(selectedEntity);
        selectedEntity = null;
    }

    public void cancelEntity() {
        selectedEntity = null;
    }

    public BigDecimal sumCurrencies() {
        try {
            BigDecimal result = currencyBaseConverter.getValue(getUserCurrencies(), showOffCurrencyCode);
            return result;
        } catch (NoCurrencyDataException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hiba!", "Nincs ilyen adat!"));
            return BigDecimal.ZERO;
        }

    }

    public String getShowOffCurrencyCode() {
        return showOffCurrencyCode;
    }

    public void setShowOffCurrencyCode(String showOffCurrencyCode) {
        this.showOffCurrencyCode = showOffCurrencyCode;
    }

    public void deleteEntity() {
        ownedCurrencyService.delete(selectedEntity);
    }

    public List<PreCalculatedRecommendation> getRecommendedCurrencies() {
        return preCalculatedRecommendationService.getBiggestRecommendations();
    }

}
