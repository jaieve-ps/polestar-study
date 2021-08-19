package com.polestarhc.study4;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class ExcelWriteStudyClass {

    private static final String FILE_NAME = "testfileForFileIO/StudyClassExcel.xlsx";

    public static void main(String[] args) {
        /* TODO 아파치포이 라이브러리 버전에 의한 WARNING을 버전을 바꿔서 없애보기 -> 3.15 -> 4.1 ver */
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("StudyList");

        String[][] studyTypes = getStudyTwoDimensionalArray();

        int rowNum = 0;
        System.out.println("Creating excel");
        for (Object[] datatype : studyTypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

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
    private static String[][] getStudyTwoDimensionalArray() {
        List<Study> studyList = new ArrayList<Study>();
        for(int i = 0; i < 50;i++){
            Study study = new Study();
            study.setStudyUid(String.valueOf(i));
            study.setPatiendId("S"+i);
            study.setPatientName("홍서연"+i);
            studyList.add(study);
        }

        List<String> studyFieldList = new ArrayList<String>();
        for(Field f: studyList.get(0).getClass().getDeclaredFields()){
            studyFieldList.add(f.getName());  // 필드 19개
        }

        String[][] studyTypes = new String[studyList.size()+1][studyFieldList.size()];

//        studyTypes[0][0] = "Study.PatientId";
//        studyTypes[0][1] = "Study.PatientName";
        for(int i = 0; i < studyList.size()+1; i++){
            for(int j = 0;j < studyFieldList.size();j++){
                if(i ==0){
                    studyTypes[i][j] = studyFieldList.get(j);

                } else {
                    if(j == 7){
                        studyTypes[i][j] = studyList.get(i-1).getPatiendId();
                    } else if (j == 8){
                        studyTypes[i][j] = studyList.get(i-1).getPatientName();
                    } else {
                        studyTypes[i][j] = "";
                    }
                }
            }
        }
        System.out.println("===========================");
        for(String[] row:studyTypes) {
            for(int i = 0;i < row.length;i++){
                boolean isNull = row[i].isBlank();
                if (!isNull) {
                }
            }
        }
        return studyTypes;
    }
}
