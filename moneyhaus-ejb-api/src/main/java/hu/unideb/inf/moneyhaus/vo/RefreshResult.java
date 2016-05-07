package hu.unideb.inf.moneyhaus.vo;

import java.util.Date;

public class RefreshResult {

	private Date date;

	private RefreshStatus status;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public RefreshStatus getStatus() {
		return status;
	}

	public void setStatus(RefreshStatus status) {
		this.status = status;
	}

}
