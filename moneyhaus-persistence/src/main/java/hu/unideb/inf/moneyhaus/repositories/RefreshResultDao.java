package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.moneyhaus.entities.RefreshResultEntity;
import java.util.Date;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public interface RefreshResultDao extends JpaRepository<RefreshResultEntity, Long> {

    @Query("SELECT max(r.date) FROM RefreshResultEntity r WHERE r.status = hu.unideb.inf.moneyhaus.entities.ResultStatusEntity.SUCCESSFUL")
    public Date findLastSuccessfulRefreshmentDate();
    
}
