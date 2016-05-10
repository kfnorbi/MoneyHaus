package hu.unideb.inf.moneyhaus.service.impl;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.inf.moneyhaus.converter.GenericConverter;
import hu.unideb.inf.moneyhaus.repositories.UserDao;
import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.vo.UserVO;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless(mappedName="userService")
@Remote(UserService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceImpl implements UserService,Serializable{

        private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserVO findById(Long id) {
		return GenericConverter.mapTo(userDao.findOne(id), UserVO.class);
	}

	@Override
	public UserVO findByUsername(String username) {
                logger.debug("Trying to find " + username + ".");
		return GenericConverter.mapTo(userDao.findByUserName(username), UserVO.class);
	}	
	
}
