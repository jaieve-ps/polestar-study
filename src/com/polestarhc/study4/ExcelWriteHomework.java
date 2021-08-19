package com.polestarhc.study4;

import com.polestarhc.study.ApplicationTest;
import com.polestarhc.study.IExcel;
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

public class ExcelWriteHomework {

    private static final String FILE_NAME = "testfileForFileIO/";
    private static final String[] STUDY_HEADERS = {"patientId", "patientName"};
    private static final String[] HOSPITAL_HEADERS = {"hospitalName", "hospitalAbbr","hospitalArea","hospitalAddress","bedCount"};

    public static void main(String[] args) {
        /* TODO 아파치포이 라이브러리 버전에 의한 WARNING을 버전을 바꿔서 없애보기 -> 3.15 -> 4.1 ver */

        ApplicationTest app = new ApplicationTest();

        List<IExcel> studyList = app.makeStudyList(); // Study 클래스
        List<IExcel> HospitalList = app.makeHospitalList(); // Hospital 클래스
        ExcelWriteHomework excelWriteHomework = new ExcelWriteHomework();

        excelWriteHomework.makeExcel("StudyClassExcel.xlsx",studyList);
        excelWriteHomework.makeExcel("HospitalClassExcel.xlsx",HospitalList);

    }

    private void makeExcel(String fileName,List<IExcel> list) {
        String filepath = FILE_NAME + fileName;
        String[] METHOD_HEADER = null;
        if (fileName.contains("Study")) {
            METHOD_HEADER = STUDY_HEADERS;
        } else if (fileName.contains("Hospital")){
            METHOD_HEADER = HOSPITAL_HEADERS;
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("StudyList");

        System.out.println("Creating excel");
        int rowNum = 0;
        int colNum = 0;
        Row row = sheet.createRow(rowNum++);
        for(int i = 0; i < METHOD_HEADER.length;i++){
            row.createCell(colNum++).setCellValue(METHOD_HEADER[colNum-1]);
        }
        colNum=0; // row = 1, col = 0

        for(int i = 0; i < 10;i++){ //list.size()
            row = sheet.createRow(rowNum++);
            Cell cell = null;
            for(int j = 0; j < METHOD_HEADER.length;j++){
                row.createCell(colNum++).setCellValue(String.valueOf(list.get(i).getValue(METHOD_HEADER[colNum-1])));
                System.out.println(list.get(i).getValue(METHOD_HEADER[colNum-1]));
            }
            colNum=0;
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(filepath);
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
