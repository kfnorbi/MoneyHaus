package hu.unideb.inf.moneyhaus.service;

import hu.unideb.inf.moneyhaus.vo.RefreshResult;

public interface RefreshResultService {

	public void save(RefreshResult result);
	
	public RefreshResult findLastSuccessful();

	public RefreshResult findLastUnuccessful();
	
}
