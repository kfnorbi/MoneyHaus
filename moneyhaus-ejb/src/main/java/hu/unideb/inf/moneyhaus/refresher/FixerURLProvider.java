package hu.unideb.inf.moneyhaus.refresher;

import java.net.MalformedURLException;
import java.net.URL;

@Deprecated
public class FixerURLProvider implements URLProvider {

	private final String API_LOCATION = "http://api.fixer.io/latest";

	private final String BASE = "USD";

	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL(API_LOCATION + "?base=" + BASE);
	}

}
