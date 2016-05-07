package hu.unideb.inf.moneyhaus.security;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.vo.UserVO;

@ManagedBean
public class UserMBean implements Serializable {

	private static final long serialVersionUID = 7010773534969463937L;

	private UserVO user;

	@EJB
	UserService userService;

	public UserVO getUser() {

		if (user == null) {
			String userName = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
			user = userService.findByUsername(userName);
		}

		return user;
	}

}
