package mfscraping.dto;

public class MFFundManagement {

	private final String mfid;
	private final String fund_management_info;
	
	public MFFundManagement(String mfid,String fund_management_info) {
		this.mfid=mfid;
		this.fund_management_info=fund_management_info;
	}

	public String getMfid() {
		return mfid;
	}

	public String getFund_management_info() {
		return fund_management_info;
	}
}
