package hu.unideb.inf.moneyhaus.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

/**
 * A java class representing the user roles for accessing functions of the
 * application.
 *
 * @see hu.unideb.inf.moneyhaus.entities.UserEntity
 */
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    /**
     * The value of the role owned by users.
     */
    @Column(name = "role")
    private String value;

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.value);
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
        final RoleEntity other = (RoleEntity) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the role's name.
     *
     * @return the role's name
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the roles name.
     *
     * @param value the roles name
     */
    public void setValue(String value) {
        this.value = value;
    }

}
