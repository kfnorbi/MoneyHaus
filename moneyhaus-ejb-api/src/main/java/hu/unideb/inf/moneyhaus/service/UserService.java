package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.validation.exception.ValidationException;
import hu.unideb.inf.moneyhaus.vo.RegistrationRequest;
import hu.unideb.inf.moneyhaus.vo.UserVO;

public interface UserService {

	public UserVO findById(Long id);
	
	public UserVO findByUsername(String username);
        
        public boolean exists(String userName);
        
        public void registrate(RegistrationRequest registrationRequest) throws ValidationException;
}
