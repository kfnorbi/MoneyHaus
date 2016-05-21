
package hu.unideb.inf.moneyhaus.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("dateConverter")
public class DateConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
        Date date = (Date)value;
        return format.format(date);
    }
    
}
