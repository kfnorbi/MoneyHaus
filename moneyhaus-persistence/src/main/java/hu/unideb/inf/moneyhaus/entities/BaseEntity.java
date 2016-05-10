package hu.unideb.inf.moneyhaus.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	@Transient
	protected static final long serialVersionUID = -8607098948552104336L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

}