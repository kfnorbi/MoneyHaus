package hu.unideb.inf.moneyhaus.entities;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * This class is a persistent representation of a user which is capable of
 * holding values for authenticating.
 *
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    /**
     * The username of the user.
     */
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    /**
     * The password of the user.
     */
    @Column(name = "passwd", nullable = false)
    private String password;

    /**
     * The email address of the user.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * The first name of the user.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the user.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The age of the user.
     */
    @Column(name = "age")
    private int age;

    /**
     * The roles of the user.
     */
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_roles_sw", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles;

    /**
     * Default constructor.
     */
    public UserEntity() {

    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the name of the user.
     *
     * @param userName the name of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Return the password of the user.
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
     * @param email the email address of the user
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
     * @param age the age of the user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the roles of the user.
     *
     * @return the roles of the user.
     */
    public List<RoleEntity> getRoles() {
        return roles;
    }

    /**
     * Sets the roles of the user.
     *
     * @param roles the roles of the user.
     */
    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

}
