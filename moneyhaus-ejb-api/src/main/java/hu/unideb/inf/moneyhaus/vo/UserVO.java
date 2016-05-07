package hu.unideb.inf.moneyhaus.vo;

import java.util.List;

@SuppressWarnings("unused")
public class UserVO {

    private String userName;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private List<OwnedCurrency> currencies;

    private int age;

    private List<RoleVO> roles;

    public List<OwnedCurrency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<OwnedCurrency> currencies) {
        this.currencies = currencies;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

}
