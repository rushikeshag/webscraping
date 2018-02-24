package mfscraping.dto;

public class MFQuarterlyReturns {
	
	private final String mfid;
	private final int Year;
	private final int Quater;
	private final double fund_return;
	
	
	public MFQuarterlyReturns(String mfid,int Year,int Quater,double fund_return) {
		this.mfid=mfid;
		this.Year=Year;
		this.Quater=Quater;
		this.fund_return=fund_return;
	}


	public String getMfid() {
		return mfid;
	}


	public int getYear() {
		return Year;
	}


	public int getQuater() {
		return Quater;
	}


	public double getFund_return() {
		return fund_return;
	}
}
