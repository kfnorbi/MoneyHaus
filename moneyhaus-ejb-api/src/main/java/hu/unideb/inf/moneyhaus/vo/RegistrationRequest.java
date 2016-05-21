
package hu.unideb.inf.moneyhaus.vo;

import java.util.Objects;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.userName);
        hash = 31 * hash + Objects.hashCode(this.password);
        hash = 31 * hash + Objects.hashCode(this.passwordConfirmation);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.lastName);
        hash = 31 * hash + Objects.hashCode(this.firstName);
        hash = 31 * hash + this.age;
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistrationRequest other = (RegistrationRequest) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.passwordConfirmation, other.passwordConfirmation)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        return true;
    }

}
