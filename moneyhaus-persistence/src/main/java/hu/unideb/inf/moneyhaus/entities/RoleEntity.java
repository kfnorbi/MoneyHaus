package hu.unideb.inf.moneyhaus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="roles")
public class RoleEntity extends BaseEntity {

	@Column(name="role")
	private String value;
	
}
