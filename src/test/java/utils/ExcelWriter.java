package utils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ExcelWriter {

    public static void appendDataExcel(int orderNo,String paymentMethod,String userType,String item){
        File file=new File(Constants.ORDER_EXCEl_FILE_PATH);
        try{
            if(!file.exists()){
                XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
                XSSFSheet sheet=xssfWorkbook.createSheet("BOPISOrders");
                Row row= sheet.createRow(0);
                row.createCell(0).setCellValue("Order Number");
                row.createCell(1).setCellValue("Date");
                row.createCell(2).setCellValue("By");
                row.createCell(3).setCellValue("Payment Method");
                row.createCell(4).setCellValue("User Type");
                row.createCell(5).setCellValue("Item Type");
                FileOutputStream fileOutputStream=   new FileOutputStream(file);
                xssfWorkbook.write(fileOutputStream);
                fileOutputStream.close(); // Close fileOutputStream
                xssfWorkbook.close();
            }
            FileInputStream fileInputStream=new FileInputStream(Constants.ORDER_EXCEl_FILE_PATH);
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet=xssfWorkbook.getSheet("BOPISOrders");
            int lastRow=sheet.getLastRowNum();
            Row row=sheet.createRow(lastRow+1);
            row.createCell(0).setCellValue(orderNo);
            row.createCell(1).setCellValue(getDate());
            row.createCell(2).setCellValue("Elisa");
            row.createCell(3).setCellValue(paymentMethod);
            row.createCell(4).setCellValue(userType);
            row.createCell(5).setCellValue(item);
            FileOutputStream fileOutputStream=   new FileOutputStream(file);
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close(); // Close fileOutputStream
            xssfWorkbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getDate(){
        LocalDate date = LocalDate.now();  // Get current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMMyyyy", Locale.ENGLISH);
        return date.format(formatter);
    }
}







