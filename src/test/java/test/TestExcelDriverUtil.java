package test;

import commonLibs.utils.ExcelDriver;
import org.testng.annotations.Test;

public class TestExcelDriverUtil {

    @Test
    public void verifyTestExcelDriverUtils() throws Exception{
        ExcelDriver excelDriver = new ExcelDriver();
        String excelWorkbook = System.getProperty("user.dir") + "/testData/excelWorkbook.xlsx";
        String sheetName = "TestData";

        excelDriver.createWorkbook(excelWorkbook);
        excelDriver.openWorkbook(excelWorkbook);
        excelDriver.createSheet(sheetName);

        excelDriver.setCellData(sheetName, 0,0, "Goran");
        excelDriver.setCellData(sheetName,0,1,"Ordovician");

        excelDriver.setCellData(sheetName, 1,0, "Petar");
        excelDriver.setCellData(sheetName,1,1,"Petrovic");

        excelDriver.saveFile();
        excelDriver.closeWorkbook();



    }
}
