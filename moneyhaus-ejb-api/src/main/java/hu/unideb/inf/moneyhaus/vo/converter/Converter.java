package hu.unideb.inf.moneyhaus.vo.converter;

import java.util.List;

public interface Converter<T, U> {

	public T toEntity(U u);

	public U toVO(T t);

	public List<T> toEntity(List<U> u);

	public List<T> toVO(List<T> t);
}
