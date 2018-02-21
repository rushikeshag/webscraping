package mfscraping;

import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import mfscraping.dao.MFDAO;
import mfscraping.dao.fs.MFDAOFsImpl;
import mfscraping.dto.TableMeta;
import mfscraping.dto.TableRow;

public class MFSchemeExtractor {

	public void extractSchems(TableMeta table) {
		String baseUrlString = "https://www.fundsindia.com/content/jsp/LP/Topschemes/displayCurrentNAV.jsp?";
		try {
			List<TableRow> rows = table.getRows();
			for (Iterator<TableRow> iterator = rows.iterator(); iterator.hasNext();) {
				TableRow mf = iterator.next();
				// "aC=400040&divid=0.2234234a2"

				String parameterString = "aC=" + mf.getCode() + "&divid=" + Math.random();

				String url = new String(baseUrlString + parameterString);

				Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
				Elements temp = doc.getElementsByAttributeValue("name", "scheme");
				Elements options = temp.select("select > option");
				String value = "";

				TableMeta schemeTable = new TableMeta(mf.getName());

				for (Element option : options.next()) {
					String text = option.text();
					value = option.attr("value");
					schemeTable.add(TableRow.create(Integer.valueOf(value), text));
				}
				MFDAO mfDAO = new MFDAOFsImpl();
				mfDAO.saveMFNames(schemeTable);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
