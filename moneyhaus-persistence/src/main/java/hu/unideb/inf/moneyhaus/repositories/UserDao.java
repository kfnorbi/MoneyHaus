package hu.unideb.inf.moneyhaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.inf.moneyhaus.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserName(String userName);
	
}
