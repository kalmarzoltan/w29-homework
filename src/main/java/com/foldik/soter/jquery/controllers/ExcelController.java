package com.foldik.soter.jquery.controllers;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RestController
public class ExcelController {

    @RequestMapping("/excel")
    public String excelCreator() {


        DateFormat df = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");

        Date today = Calendar.getInstance().getTime();

        String reportDate = df.format(today);


        String filename = "C:/Users/Kalmi/Documents/TestFolder/NewExcelFile " + reportDate + ".xls";

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("FirstSheet");
        CreationHelper CreationHelper = wb.getCreationHelper();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(CreationHelper.createDataFormat().getFormat("m/d/yy h:mm:ss"));
        sheet.setColumnWidth(0, 4000);

        cell = row.createCell(0);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "Excel file generated with name: \"NewExcelFile "+reportDate+".xls\"";

    }

}
