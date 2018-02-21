package mfscraping.impl.fundsind;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import mfscraping.MFSchemeExtractor;
import mfscraping.api.MFDataScraper;
import mfscraping.dao.MFDAO;
import mfscraping.dao.fs.MFDAOFsImpl;
import mfscraping.dto.TableMeta;
import mfscraping.dto.TableRow;

public class FundsIndiaScrapper implements MFDataScraper {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startScraping() {
		
		String url = new String("https://www.fundsindia.com/content/jsp/SDNAVFunds.do");
		try {
			Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
			Elements temp = doc.getElementsByClass("amcselect form-control");	
			Elements options = temp.select("select > option");

			String value = "";
			TableMeta table = new TableMeta("MFNames");
			
			for (Element option : options.next()) {
				String text = option.text();
				value = option.attr("value");
				table.add(TableRow.create(Integer.valueOf(value), text));
			}

			MFDAO mfDAO = new MFDAOFsImpl();
			mfDAO.saveMFNames(table);
			
			new MFSchemeExtractor().extractSchems(table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNAVScraping() {
		// TODO Auto-generated method stub
		
	}

}
