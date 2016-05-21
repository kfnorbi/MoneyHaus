package hu.unideb.inf.moneyhaus.refresher.exception;

public class CurrencyRefreshingException extends Exception {

	public CurrencyRefreshingException() {
		super();
	}

	public CurrencyRefreshingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CurrencyRefreshingException(String message, Throwable cause) {
		super(message, cause);
	}

	public CurrencyRefreshingException(String message) {
		super(message);
	}

	public CurrencyRefreshingException(Throwable cause) {
		super(cause);
	}

}
