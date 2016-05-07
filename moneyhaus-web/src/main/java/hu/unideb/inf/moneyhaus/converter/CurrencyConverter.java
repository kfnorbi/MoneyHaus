/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.converter;

import java.util.Currency;
import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Nolbelt
 */
@FacesConverter(value = "currencyConverter")
public class CurrencyConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Currency.getInstance(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String currency = (String)value;
        return Currency.getInstance(currency).getDisplayName(Locale.getDefault());
    }
    
}
