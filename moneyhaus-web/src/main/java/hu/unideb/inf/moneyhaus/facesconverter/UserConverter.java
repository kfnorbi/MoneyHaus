// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.facesconverter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.vo.UserVO;

@FacesConverter("userConverter")
public class UserConverter implements Converter {

	@EJB
	UserService userService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return userService.findByUsername(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof UserVO) {
			UserVO user = (UserVO) value;
			return user.getUserName();
		} else {
			throw new IllegalArgumentException(
					"The class " + this.getClass().getName() + " got invalid parameter to convert.");
		}
	}

}
