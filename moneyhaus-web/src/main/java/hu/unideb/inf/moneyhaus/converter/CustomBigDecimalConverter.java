
package hu.unideb.inf.moneyhaus.converter;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.BigDecimalConverter;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("customBigDecimalConverter")
public class CustomBigDecimalConverter extends BigDecimalConverter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return super.getAsObject(context, component, value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        BigDecimal decimal = (BigDecimal)value;
        decimal = decimal.setScale(2);
        return super.getAsString(context, component, decimal);
    }
    
}
