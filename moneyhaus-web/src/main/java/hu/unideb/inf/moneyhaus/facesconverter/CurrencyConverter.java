// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.facesconverter;

import java.util.Currency;
import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "currencyConverter")
public class CurrencyConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Currency.getInstance((String)value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String currency = (String)value;
        return currency;
    }
    
}
