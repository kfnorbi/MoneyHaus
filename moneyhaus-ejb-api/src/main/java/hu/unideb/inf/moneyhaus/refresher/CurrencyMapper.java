package hu.unideb.inf.moneyhaus.refresher;


import hu.unideb.inf.moneyhaus.vo.CurrencyRateVO;
import java.util.Date;
@Deprecated
public interface CurrencyMapper {

	public CurrencyRateVO map(String code, Double value,String base,Date dateTime);
	
}
