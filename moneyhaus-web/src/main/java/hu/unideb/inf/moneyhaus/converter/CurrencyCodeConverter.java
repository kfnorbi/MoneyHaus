/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter;

import java.util.Currency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

/**
 *
 * @author Nolbelt
 */
@FacesConverter("currenciesCodeConverter")
public class CurrencyCodeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String currencyCode = (String) value;
        return Currency.getInstance(currencyCode).getDisplayName();
    }
    
    
}
