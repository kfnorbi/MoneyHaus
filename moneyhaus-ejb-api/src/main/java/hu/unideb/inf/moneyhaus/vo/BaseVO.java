package hu.unideb.inf.moneyhaus.vo;

import java.io.Serializable;

@SuppressWarnings("unused")
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 5309230336473179440L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
