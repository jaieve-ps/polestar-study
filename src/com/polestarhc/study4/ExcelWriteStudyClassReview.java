package com.polestarhc.study4;

import com.polestarhc.study.Study;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteStudyClassReview {

    private static final String FILE_NAME = "testfileForFileIO/StudyClassExcelReview.xlsx";

    private static String[] headers = {"patientId","patientName"};

    public static void main(String[] args) {
        /* TODO 아파치포이 라이브러리 버전에 의한 WARNING을 버전을 바꿔서 없애보기 -> 3.15 -> 4.1 ver */
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("StudyList");

        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
//        int colNum = 0;
//        Cell cell = row.createCell(colNum);
//        cell.setCellValue("나는 홍서연");
        int colnum = 0;

        IExcel excel = new Study();

        for(int i = 0;i < headers.length;i++){
            Cell cell = row.createCell(colnum);

            cell.setCellValue(excel.getValue(headers[0]));
        }

//        int rowNum = 0;
//        System.out.println("Creating excel");
//        for (Object[] datatype : studyTypes) {
//            Row row = sheet.createRow(rowNum++);
//            int colNum = 0;
//            for (Object field : datatype) {
//                Cell cell = row.createCell(colNum++);
//                if (field instanceof String) {
//                    cell.setCellValue((String) field);
//                } else if (field instanceof Integer) {
//                    cell.setCellValue((Integer) field);
//                }
//            }
//        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

}
