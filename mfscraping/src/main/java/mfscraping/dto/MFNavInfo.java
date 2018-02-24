package mfscraping.dto;

import java.util.Date;

public class MFNavInfo {
	
	private final String mfid;
	private final double Curent_Nav;
	private final double fiftyTow_Week_high;
	private final double fiftyTow_Week_low;
	private final Date as_of;
	
	public MFNavInfo(String mfid,double Curent_Nav,double fiftyTow_Week_high,double fiftyTow_Week_low,Date as_of)
	{
		this.mfid=mfid;
		this.Curent_Nav=Curent_Nav;
		this.fiftyTow_Week_high=fiftyTow_Week_high;
		this.fiftyTow_Week_low=fiftyTow_Week_low;
		this.as_of=as_of;
	}

	public String getMfid() {
		return mfid;
	}

	public double getCurent_Nav() {
		return Curent_Nav;
	}

	public double getFiftyTow_Week_high() {
		return fiftyTow_Week_high;
	}

	public double getFiftyTow_Week_low() {
		return fiftyTow_Week_low;
	}

	public Date getAs_of() {
		return as_of;
	}
}
