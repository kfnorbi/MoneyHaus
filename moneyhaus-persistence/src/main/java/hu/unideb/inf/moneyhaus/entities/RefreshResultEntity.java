package hu.unideb.inf.moneyhaus.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "refresh_results")
public class RefreshResultEntity extends BaseEntity {

    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ResultStatusEntity status;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ResultStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ResultStatusEntity status) {
        this.status = status;
    }

}
