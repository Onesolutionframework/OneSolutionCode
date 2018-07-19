package com.project.utilities;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/**
 * Created by Muni on 5/4/17.
 */
public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static LinkedHashMap<String[], String[]> getTableHashMap(String FilePath, String SheetName) throws Exception {

        LinkedHashMap tabArray = null;

        try {
            //System.out.println(FilePath);
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            //System.out.println(ExcelFile);
            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;

            int startCol = 1;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 2;

            tabArray = new LinkedHashMap<String[],String[]>();

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;
                int j=1;
                //for (int j = startCol; j <= totalCols; j++, cj++) {
                    tabArray.put(getCellData(i, j-1),getCellData(i,j));
                    //System.out.println(tabArray[ci][cj]);
                //}

            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return (tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            int dataType = Cell.getCellType();

            if (dataType == 3) {

                return "";

            } else {

                String CellData = Cell.getStringCellValue();

                return CellData;

            }

        }
        catch (Exception e)
        {

        throw (e);

        }
    }


    public static String getCellData1(int RowNum, int ColNum) throws Exception {

        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            int dataType = Cell.getCellType();

            if (dataType == 3) {

                return "";

            } else  {

                String CellData = Cell.getStringCellValue();

                return CellData;

            }

        }
        catch (Exception e)
        {

            throw (e);

        }


    }

    public static LinkedHashMap<String[], List<Boolean>> getTableHashMap2(String FilePath, String SheetName) throws Exception {

        LinkedHashMap tabArray = null;
        tabArray = new LinkedHashMap<String[],List<Boolean>>();
        try {
            System.out.println(FilePath);
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            System.out.println(ExcelFile);
            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;

            int startCol = 1;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 6;

            ci = 0;
            boolean blist;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                List<Boolean> tBools = new ArrayList<Boolean>();
                cj = 0;
                int j = 1;
                for ( j = startCol; j <= totalCols; j++, cj++) {
                    String stemp= getCellData1(i,j+1);
                    blist = stemp.equalsIgnoreCase("true");
                    tBools.add(blist);
                }
                String val1=getCellData1(i,j-1);
                String val2=getCellData1(i,j);
                tabArray.put(val2,tBools);
            }
        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }
        return (tabArray);


    }

    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e) {

            throw (e);

        }

    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

        int i;

        try {

            int rowCount = ExcelUtils.getRowUsed();

            for (i = 0; i < rowCount; i++) {

                if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

                    break;

                }

            }

            return i;

        } catch (Exception e) {

            throw (e);

        }

    }

    public static int getRowUsed() throws Exception {

        try {

            int RowCount = ExcelWSheet.getLastRowNum();

            return RowCount;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            throw (e);

        }

    }
}