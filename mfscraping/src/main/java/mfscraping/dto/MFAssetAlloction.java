package mfscraping.dto;

import java.util.Date;

public class MFAssetAlloction {
	
	private final String mfid;
	private final String class_alloction;
	private final Date Date;
	
	public MFAssetAlloction(String mfid,String class_alloction,Date Date) {
	
		this.mfid=mfid;
		this.class_alloction=class_alloction;
		this.Date=Date;
	}

	public String getMfid() {
		return mfid;
	}

	public String getClass_alloction() {
		return class_alloction;
	}

	public Date getDate() {
		return Date;
	}

}
