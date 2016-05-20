package hu.unideb.inf.moneyhaus.vo;

import java.util.Objects;

/**
 * This object represents a single role of a
 * {@link hu.unideb.inf.moneyhaus.vo.UserVO user}.
 */
public class RoleVO extends BaseVO {

    /**
     * The value of the user role.
     */
    private String value;

    /**
     * Constructor.
     *
     * @param value the value of the role
     */
    public RoleVO(String value) {
        this.value = value;
    }

    /**
     * Default constructor.
     */
    public RoleVO() {
    }

    /**
     * Returns the value of the role.
     *
     * @return the role of the role
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the role.
     *
     * @param value the value of the role.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.value);
        return hash;
    }

    /**
     *
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
        final RoleVO other = (RoleVO) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

}
