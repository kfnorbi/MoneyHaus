package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.RefreshResult;
import java.util.Date;

public interface RefreshResultService {

	public void save(RefreshResult result);
	
	public Date findLastSuccessful();
}
