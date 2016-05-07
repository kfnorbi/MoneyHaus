package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.UserVO;

public interface UserService {

	public UserVO findById(Long id);
	
	public UserVO findByUsername(String username);
}
