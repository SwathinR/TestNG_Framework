package TestNG.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataFilesReader{

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static Object[][] ReadExcelSpreadSheet(String FilePath, String SheetName) throws Exception {   

		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 0;
			int ci,cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			// you can write a function as well to get Column count
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("total row: "+totalRows+"\ntotal Cols: "+totalCols);
			tabArray=new String[totalRows][totalCols];
			ci=0;
			for (int i=startRow;i<=totalRows;i++, ci++) {           	   
				cj=0;
				for (int j=startCol;j<totalCols;j++, cj++){
					//System.out.println("ci= "+ci+" cj= "+cj);
					tabArray[ci][cj]=getCellData(i,j);
					//System.out.println("Cell Data: "+tabArray[ci][cj]);  
				}
			}
		}

		catch (FileNotFoundException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return(tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			//System.out.println("cellType: "+ dataType);
			if  (dataType == 3) {
				return "";
			}else if(dataType==1) {

				String CellData = Cell.getStringCellValue();
				return CellData;
			}else {
				double CellData = Cell.getNumericCellValue();
				return " ";
			}
		}catch (Exception e){
			e.printStackTrace();
			throw (e);
		}
	}

	public static void ReadCSV() {
		//TODO Add Read CSV method implementation 
	}
	@DataProvider(name="test")
	public static Object[][] dp()throws Exception{

		Object[][] data = DataFilesReader.ReadExcelSpreadSheet(System.getProperty("user.dir")+"/src/test/java/testDataFiles/Excelread.xlsx", "AddMainMenu");
		
		return data;
	}
	
	@DataProvider(name="test2")
	public static Object[][] dp2()throws Exception{

		Object[][] data = DataFilesReader.ReadExcelSpreadSheet(System.getProperty("user.dir")+"/src/test/java/testDataFiles/Excelread.xlsx", "AddSubMenu");
		
		return data;
	}

	@Test(priority=1, dataProvider="test")
	public static void  test(String MMName, String Description, String DispOrder, String test) {
		System.out.println("MainMenuName: "+MMName+" Description: "+Description+" DispOrder: "+DispOrder+" test: "+test);
	}
	
	@Test(priority=2, enabled= false, dataProvider="test2")
	public static void  test3(String MMName, String Description, String DispOrder, String test,String directLink) {
		System.out.println("MainMenuName: "+MMName+" Description: "+Description+" DispOrder: "+DispOrder+" test: "+test+" direct link: "+directLink);
	}
	
	/*public static void main(String[] args) throws Exception{
		Object[][] x = ReadExcelSpreadSheet(System.getProperty("user.dir")+"/src/test/java/TestNG/testDataFiles/Excelread.xlsx", "Credentials");
		
		System.out.println(x[0][0]);
	}*/
}