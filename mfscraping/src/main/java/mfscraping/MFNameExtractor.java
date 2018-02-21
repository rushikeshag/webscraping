package mfscraping;
import java.io.IOException;

import mfscraping.api.MFDataScraper;
import mfscraping.impl.fundsind.FundsIndiaScrapper;

public class MFNameExtractor {
	
	public static void main(String[] args) throws IOException {
		MFDataScraper fundsIndia = new FundsIndiaScrapper();
		
		fundsIndia.init();
		fundsIndia.startScraping();
		
		IndexMutualFund.indexMutualFundList();
	}

}