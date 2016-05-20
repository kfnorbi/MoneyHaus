package hu.unideb.inf.moneyhaus.vo;

import java.util.List;

/**
 * This object represents a user who is capable of logging in into the
 * application and his roles are determining the functions he can use.
 */
@SuppressWarnings("unused")
public class UserVO extends BaseVO {

    /**
     * The username of the user.
     */
    private String userName;
    /**
     * The password of the user.
     */
    private String password;
    /**
     * The email address of the user.
     */
    private String email;
    /**
     * The first name of the user.
     */
    private String firstName;
    /**
     * The last name of the user.
     */
    private String lastName;
    /**
     * The age of the user.
     */
    private int age;
    /**
     * The roles of the user.
     */
    private List<RoleVO> roles;

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     *
     * @param userName the username of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email address of the user.
     *
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the first name of the user.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the user.
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the age of the user.
     *
     * @return the age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     *
     * @param age the age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the roles of the user.
     *
     * @return the roles of the user
     */
    public List<RoleVO> getRoles() {
        return roles;
    }

    /**
     * Sets the roles of the user.
     *
     * @param roles the roles of the user
     */
    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

}
