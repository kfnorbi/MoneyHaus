package hu.unideb.inf.moneyhaus.service.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.entities.RefreshResultEntity;
import hu.unideb.inf.moneyhaus.repositories.RefreshResultDao;
import hu.unideb.inf.moneyhaus.service.RefreshResultService;
import hu.unideb.inf.moneyhaus.vo.RefreshResult;
import java.util.Date;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RefresherResultServiceImpl implements RefreshResultService {

    @Autowired
    RefreshResultDao refreshResultDao;

    @Override
    public void save(RefreshResult result) {
        RefreshResultEntity entity = GenericConverter.mapTo(result, RefreshResultEntity.class);
        refreshResultDao.save(entity);
    }

    @Override
    public Date findLastSuccessful() {
        return refreshResultDao.findLastSuccessfulRefreshmentDate();
    }

}
