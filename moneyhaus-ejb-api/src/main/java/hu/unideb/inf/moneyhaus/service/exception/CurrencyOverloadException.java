/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.service.exception;

/**
 *
 * @author Nolbelt
 */
public class CurrencyOverloadException extends Exception {

    public CurrencyOverloadException(String message) {
        super(message);
    }
    
}
