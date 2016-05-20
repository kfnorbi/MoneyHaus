package hu.unideb.inf.moneyhaus.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 *
 * This is a base abstract class for extracting ids from entities.
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
     * Default Serial version id for all the entities.
     */
    @Transient
    protected static final long serialVersionUID = -8607098948552104336L;

    /**
     * The common id field of all the entities.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Returns null if the object is not yet persisted.
     *
     * @return the database id of this object
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the object.
     *
     * @param id the id of the object
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

}
