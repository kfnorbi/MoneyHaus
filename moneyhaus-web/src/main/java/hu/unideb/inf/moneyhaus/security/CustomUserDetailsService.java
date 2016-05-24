// CHECKSTYLE:OFF
package hu.unideb.inf.moneyhaus.security;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.unideb.inf.moneyhaus.service.UserService;
import hu.unideb.inf.moneyhaus.vo.RoleVO;
import hu.unideb.inf.moneyhaus.vo.UserVO;

@Service
@EJB(name = "moneyhaus.userService", beanInterface = UserService.class)
public class CustomUserDetailsService implements UserDetailsService {

	@EJB
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userService.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("The user " + username + " not found.");
		} else {
			return new User(user.getUserName(), user.getPassword(), mapRoles(user.getRoles()));
		}
	}

	private List<GrantedAuthority> mapRoles(List<RoleVO> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleVO r : roles) {
			authorities.add(new SimpleGrantedAuthority(r.getValue()));
		}
		return authorities;
	}

}
