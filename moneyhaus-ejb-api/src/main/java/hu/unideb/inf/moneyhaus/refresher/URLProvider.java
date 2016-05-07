package hu.unideb.inf.moneyhaus.refresher;

import java.net.MalformedURLException;
import java.net.URL;

@Deprecated
public interface URLProvider  {

	public URL getUrl() throws MalformedURLException;
	
}
