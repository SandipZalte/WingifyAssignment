package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import Base.BaseClass;

public class Util extends BaseClass {

	/*-------------- 1st type of Screenshot----------*/

	public static void takescreenshotwithname( String name) throws IOException {
		String d = Util.getdate(); // method of time class

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./WingifyAssignment/test-output"+ name + " " + d + ".png");
		FileHandler.copy(source, destination);

	}
	public static void TakeScreenshot(String Name) {
		TakesScreenshot tc = ((TakesScreenshot) driver);
		File Source = tc.getScreenshotAs(OutputType.FILE);
		 File screenShotPath = new File(System.getProperty("user.dir")+"./test-output/Screenshot" + Name + " " + getDateTime() + ".Png");
		try {
			FileHandler.copy(Source, screenShotPath);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

		public static String getDateTime() {

			Date dt = (Date) Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
			String newdatetime = sdf.format(dt);
			return newdatetime;
		}
	public static String getdate() { // method

		Date dt = (Date) Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String date = sdf.format(dt);
		return date;
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static String[] Comparator_To_SORT( List<WebElement> listColElement) {
		String[] list = new String[listColElement.size()];

			for (int i = 0; i < listColElement.size(); i++) {
				list[i] = listColElement.get(i).getText();
			}

			for (String j : list) {
//				System.out.println("Unsorted List ->");
//				System.out.println(j);
			}

			Arrays.sort(list, new Comparator<String>() {

				public int compare(String o1, String o2) {
					String no1 = o1.replaceAll("[a-zA-Z,\\s]", "");
					String no2 = o2.replaceAll("[a-zA-Z, \\s]", "");
					double num1 = Double.parseDouble(no1);
					double num2 = Double.parseDouble(no2);

					if (num1 < num2)
						return -1;
					else if (num1 > num2)
						return 1;
					return 0;
				}
			});
			return list;


			// System.out.println("Expected List "+Arrays.toString(expected));

		
		}
	
		public static String getdata(String name, int row, int cell) throws EncryptedDocumentException, IOException {
			FileInputStream file = new FileInputStream("F:\\TESTING\\AUTOMATION\\Excel Input Data\\Test Data.xlsx");
			String value = WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(cell).getStringCellValue();
			return value;

		}


}
