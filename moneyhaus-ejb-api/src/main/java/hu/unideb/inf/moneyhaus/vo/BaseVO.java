package hu.unideb.inf.moneyhaus.vo;

import java.io.Serializable;

/**
 * This class helps to manage the {@code id} field of the entities.
 */
@SuppressWarnings("unused")
public abstract class BaseVO implements Serializable {

    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 5309230336473179440L;
    /**
     * The common id field of the persistent objects.
     */
    private Long id;

    /**
     * Returns the id of the object.
     *
     * @return the id of the object
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the object.
     *
     * @param id the id to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
