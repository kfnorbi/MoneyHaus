/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.moneyhaus.vo;

/**
 *
 * @author Nolbelt
 */
public class RegistrationRequest {

    /**
     * The username of the registration request.
     */
    private String userName;
    /**
     * The password of the registration request.
     */
    private String password;
    /**
     * The password confirmation of the registration request.
     */
    private String passwordConfirmation;
    /**
     * The email address of the registration request.
     */
    private String email;
    /**
     * The last name of the registration request.
     */
    private String lastName;
    /**
     * The first name of the registration request.
     */
    private String firstName;
    /**
     * The age of the registration request.
     */
    private int age;

    /**
     * Returns the age of the registration request.
     *
     * @return the age of the registration request
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the registration request.
     *
     * @param age the age of the registration request
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the username of the registration request.
     *
     * @return the username of the registration request
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the registration request.
     *
     * @param userName the username of the registration request
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the password of the registration request.
     *
     * @return the password of the registration request
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the registration request.
     *
     * @param password the password of the registration request
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email address of the registration request.
     *
     * @return the email address of the registration request
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the registration request.
     *
     * @param email the email address of the registration request
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the last name of the registration request.
     *
     * @return the last name of the registration request
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the registration request.
     *
     * @param lastName the last name of the registration request
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the registration request.
     *
     * @return the first name of the registration request
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the registration request.
     *
     * @param firstName the first name of the registration request
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the password confirmation of the registration request.
     *
     * @return the password confirmation of the registration request
     */
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    /**
     * Sets the password confirmation of the registration request.
     *
     * @param passwordConfirmation the password confirmation of the registration
     * request
     */
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}
