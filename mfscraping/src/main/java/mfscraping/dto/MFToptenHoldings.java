package mfscraping.dto;

public class MFToptenHoldings {
	
	private final String mfid;
	private final String holdings;
	
	public MFToptenHoldings(String mfid,String holdings)
	{
		this.mfid=mfid;
		this.holdings=holdings;
	}

	public String getMfid() {
		return mfid;
	}

	public String getHoldings() {
		return holdings;
	}
	
}
