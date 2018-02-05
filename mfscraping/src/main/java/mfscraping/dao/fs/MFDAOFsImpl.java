package mfscraping.dao.fs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.csvreader.CsvWriter;

import mfscraping.dao.MFDAO;
import mfscraping.dto.TableMeta;
import mfscraping.dto.TableRow;

public class MFDAOFsImpl implements MFDAO {

	@Override
	public void saveMFNames(TableMeta table) {
		try {
			List<TableRow> mfObjs = table.getRows();
			String outputFile = "D:/Rushi/"+table.name()+".csv";
			Files.deleteIfExists(Paths.get(outputFile));
			boolean alreadyExists = new File(outputFile).exists();

			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			if (!alreadyExists) {
				csvOutput.write("Value");
				csvOutput.write("Mutual Fund");
				csvOutput.endRecord();
			}
			for (Iterator<TableRow> iterator = mfObjs.iterator(); iterator.hasNext();) {
				TableRow mf = iterator.next();
				csvOutput.write(mf.getCode() + "");
				csvOutput.write(mf.getName());
				csvOutput.endRecord();
			}
			csvOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
