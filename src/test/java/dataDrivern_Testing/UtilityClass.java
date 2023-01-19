package dataDrivern_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class UtilityClass {

	public String readdata="F:\\S\\B\\RestAssuredAutomation\\src\\test\\java\\dataDrivern_Testing\\excel\\Book1.xlsx";
	@Test
	public static void readEXCEL() throws EncryptedDocumentException, IOException{
		FileInputStream file=new FileInputStream("F:\\S\\B\\RestAssuredAutomation\\src\\test\\java\\dataDrivern_Testing\\excel\\Book1.xlsx");
		
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		
		for (int i=0; i<=5; i++) {
			for(int j=0; j<=5; j++) {
			 String data = sheet.getRow(i).getCell(j).getStringCellValue();
			 
			 System.out.println(data);
			
		}
		}
	
		
	}
}
