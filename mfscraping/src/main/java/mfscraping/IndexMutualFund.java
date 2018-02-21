package mfscraping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.csvreader.CsvWriter;

public class IndexMutualFund {

	static void indexMutualFundList()
	{
		String url = new String("https://www.fundsindia.com/products/mutual-fund/category/Equity-Index-funds?ccode=13");
		Document doc;
		try {
			String outputFile = "D:/Rushi/1_INDEX_MUTUAL_FUND.csv";
			Files.deleteIfExists(Paths.get(outputFile));
			boolean alreadyExists = new File(outputFile).exists();
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
			Elements table = doc.getElementsByClass("selecttable table");	
			Elements tableRow = table.select("tr");
			//System.out.println("Options : "+options.toString());
			if (!alreadyExists) {
				csvOutput.write("Scheme");
				csvOutput.write("Sector");
				csvOutput.write("Type");
				csvOutput.write("Min. Invest(Rs.)");
				csvOutput.write("NAV(Rs.)");
				csvOutput.write("FundsIndia Rating");
				csvOutput.write("Exp. Ratio(%)");
				csvOutput.write("SIP Min. Inv.(Rs.)");
				csvOutput.write("Invest");
				csvOutput.endRecord();
			}
			for (Element option : tableRow) {
				
				Elements rw=option.select("td");
				for(Element row: rw)
				{
					String text = row.text();
					System.out.println(text);
					csvOutput.write(text);	
				}
				csvOutput.endRecord();
				System.out.println();
			}
			csvOutput.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
