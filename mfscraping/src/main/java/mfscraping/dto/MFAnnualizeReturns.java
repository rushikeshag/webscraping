package mfscraping.dto;

import java.util.Date;

public class MFAnnualizeReturns {

	private final String mfid;
	private final int Year;
	private final double fund_return;
	
	public MFAnnualizeReturns(String mfid,int Year,double fund_return) {
		this.mfid=mfid;
		this.Year=Year;
		this.fund_return=fund_return;
	}

	public String getMfid() {
		return mfid;
	}

	public int getYear() {
		return Year;
	}

	public double getFund_return() {
		return fund_return;
	}
}
