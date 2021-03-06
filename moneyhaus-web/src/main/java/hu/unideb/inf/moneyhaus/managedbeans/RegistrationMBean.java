// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class RegistrationMBean {

    private RegistrationRequest registrationRequest;

    @EJB
    private UserService userService;

    @PostConstruct
    public void init(){
        registrationRequest = new RegistrationRequest();
    }
    
    public void doRegistrate() throws IOException {
        try {
            userService.registrate(registrationRequest);
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (ValidationException ex) {
            for (ValidationViolation violation : ex.getViolations()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(violation.getMessage()));
            }
        }
    }

    public RegistrationRequest getRegistrationRequest() {
        return registrationRequest;
    }

    public void setRegistrationRequest(RegistrationRequest registrationRequest) {
        this.registrationRequest = registrationRequest;
    }

}
