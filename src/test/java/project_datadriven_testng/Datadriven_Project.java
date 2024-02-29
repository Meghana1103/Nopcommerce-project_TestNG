package project_datadriven_testng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Datadriven_Project {
public Object[][] readfile() throws EncryptedDocumentException, IOException{
		
		FileInputStream file=new FileInputStream("C:\\Users\\pavan\\Desktop\\Nopcommerce_project\\project_datadriven_testng\\src\\main\\resources\\ProjectExcel.xlsx"); 
		
		Workbook excel=WorkbookFactory.create(file);
		Sheet sheet=excel.getSheet("Register");
		
		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(4).getLastCellNum();
		
        Object[][] obj=new Object[rows][columns];
  
		for(int i=0;i<rows; i++) {			
			for(int j=0;j<columns;j++) {				
				obj[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();	
				System.out.println(obj);
			}
		}	
		return obj;
	}		
}
