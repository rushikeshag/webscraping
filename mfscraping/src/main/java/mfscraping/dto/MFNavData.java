package mfscraping.dto;

import java.util.Date;

public class MFNavData {
	private final String mfid;
	private final Date date;
	private final double Nav;
	private final double repurchase_price;
	private final double sale_price;
	
	public MFNavData(String mfid,Date date,double Nav,double repurchase_price,double sale_price)
	{
		this.mfid= mfid;
		this.date=date;
		this.Nav=Nav;
		this.repurchase_price=repurchase_price;
		this.sale_price=sale_price;
	}

	public Date getDate() {
		return date;
	}

	public double getRepurchase_price() {
		return repurchase_price;
	}

	public double getSale_price() {
		return sale_price;
	}

	public String getMfid() {
		return mfid;
	}

	public double getNav() {
		return Nav;
	}
	
	
	

}
