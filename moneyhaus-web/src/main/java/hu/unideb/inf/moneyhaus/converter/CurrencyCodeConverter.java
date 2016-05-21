
package hu.unideb.inf.moneyhaus.converter;

import java.util.Currency;
import java.util.Locale;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;


@FacesConverter("currenciesCodeConverter")
public class CurrencyCodeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String currencyCode = (String) value;
        Locale locale = context.getViewRoot().getLocale();
        return Currency.getInstance(currencyCode).getDisplayName(locale);
    }
    
    
}
