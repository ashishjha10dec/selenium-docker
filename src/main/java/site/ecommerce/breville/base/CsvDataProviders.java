package site.ecommerce.breville.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvDataProviders {
	
	static String file = "placeOrders.csv";

	@DataProvider(name = "csvReader")
	public static Iterator<Object[]> csvReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		
		if (System.getProperty("FILENAME") != null) {
			String file01 = System.getProperty("FILENAME");
			file = file01;
			
		}

		String f = file;
		File file = new File(f);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					list.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + f + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + f + " file.\n" + e.getStackTrace().toString());
		}


		return list.iterator();
	}
}
