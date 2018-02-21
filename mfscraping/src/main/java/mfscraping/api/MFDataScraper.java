package mfscraping.api;

public interface MFDataScraper {

	// initialization if any
	void init();

	// crawl the site and save to DAO
	void startScraping();

	// crawl the site for just NAV Data
	void updateNAVScraping();

}
