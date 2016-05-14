/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.managedbeans;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.validation.ValidationViolation;
import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nolbelt
 */
@ManagedBean
@ViewScoped
public class RegistrationMBean {

    RegistrationRequest registrationRequest;

    @EJB
    UserService userService;

    @PostConstruct
    public void init(){
        registrationRequest = new RegistrationRequest();
    }
    
    public void doRegistrate() {
        try {
            userService.registrate(registrationRequest);
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
