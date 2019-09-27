package util;

import model.Jobs;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelWriter {
    private static String[] columns = {"Country", "Job Count"};

    public void write(ArrayList<Jobs> jobsArrayList, String title){
        try{
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(title);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            Row headerRow = sheet.createRow(0);
            for(int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }
            int rowNum = 1;
            for(Jobs jobs: jobsArrayList){
                Row row = sheet.createRow(rowNum++);
                row.createCell(0)
                        .setCellValue(jobs.getCountryName());
                row.createCell(1)
                        .setCellValue(jobs.getJobCount());
            }
            for(int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            FileOutputStream fileOut = new FileOutputStream(title+".xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
