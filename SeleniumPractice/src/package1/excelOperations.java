/*package package1;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class excelOperations {


	public void readexcel() throws BiffException,IOException{

		String Filepath1="E:\\Selenium Practice\\TestData.xls";
		//String Filepath2="E:\\Selenium Practice\\TestDatacopy.xls"
		FileInputStream fs=new FileInputStream(Filepath1);
		//FilterOutputStream fs2=new FilterOutputStream(Filepath2);
		Workbook wb1= Workbook.getWorkbook(fs);
		//WritableWorkbook wb2=Workbook.createWorkbook(fs2);
		Sheet sh=wb1.getSheet(0);
		int totalnoofrows=sh.getRows();
		int toalnoofcolumns=sh.getColumns();
		for(int row=0; row<totalnoofrows; row++)
		{
			for(int column=0;column<toalnoofcolumns;column++)
			{
				System.out.println(sh.getCell(column,row).getContents()+"");
			}

		}





	}

	public static void main(String[] args) throws BiffException, IOException{
		excelOperations DT = new excelOperations();
		DT.readexcel();





	}

}
*/