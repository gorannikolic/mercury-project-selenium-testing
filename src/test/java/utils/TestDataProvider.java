package utils;

import commonLibs.utils.ExcelDriver;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] getUserData() throws  Exception{
        String currentWorkingDirectory = System.getProperty("user.dir");                         //find working directory
        String workbookName = currentWorkingDirectory + "/inputTestData/TestData.xlsx";          // create variable for workbook
        String sheetName = "TestData";                                                           // create varibale for sheet name

        ExcelDriver excelDriver = new ExcelDriver();                                            // initilize excel driver
        Object[][] data;

        excelDriver.openWorkbook(workbookName);                                                  //open workbook

        int rowCount = excelDriver.getRowCount(sheetName);
        int cellCount = excelDriver.getCellCountFromARow(sheetName, 0);

        data = new Object[rowCount+1][cellCount];

        for (int row=0; row <=rowCount; row++) {
            for (int cell=0; cell <cellCount; cell++){
                data[row][cell] = excelDriver.getCellData(sheetName, row, cell);
            }
        }
        return data;
    }
}
