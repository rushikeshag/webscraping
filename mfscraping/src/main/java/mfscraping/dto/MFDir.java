package mfscraping.dto;

import java.util.Date;

import mfscraping.dao.TableObject;

public class MFDir implements TableObject{
	private final String mfId;
	private final String name;
	private final String category;
	private final Date launchDate;
	private final String type;

	public MFDir(String mfId, String name, String category, Date launchDate, String type) {
		this.mfId = mfId;
		this.name = name;
		this.category = category;
		this.launchDate = launchDate;
		this.type = type;
	}

	public String getMfId() {
		return mfId;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public String getType() {
		return type;
	}
}
