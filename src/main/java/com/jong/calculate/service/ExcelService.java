package com.jong.calculate.service;

import com.jong.calculate.domain.excel.ExcelExportObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class ExcelService {

    public static String setOneValueName = "1등급 농협 한우 안심 구이용 알뜰 선물 세트";
    public static String setTwoValueName = "1등급 농협 한우 구이용 꽃등심 안심 채끝 선물 세트";
    public static String sirloinName = "등심"; // 등심 1 2
    public static String bulgogiName = "불고기"; //불고기 1
    public static String jangjorimName = "장조림"; //장조림 1
    public static String soupStockName = "국거리"; //국거리 1
    public static String reliefName = "안심"; //안심 2
    public static String chopName = "채끝"; //채끝 2

    public void excelExport(ExcelExportObject excelExportObject) throws Exception{
        System.out.println( excelExportObject.getSirloin());
//
//        Workbook workbook = null;
//        FileOutputStream fos = null;
//        try {
//            workbook = new HSSFWorkbook();// Excel Workbook 생성
//
//            Sheet sheet = workbook.createSheet("엑셀쓰기"); // Excel Sheet 생성
//
//            for (int rownum = 0; rownum < data.length; rownum++) { // data row 개수 만큼 반복해서 처리
//                Row row = sheet.createRow(rownum); // Excel Row 생성
//
//                for (int column = 0; column < data[rownum].length; column++) { // data row의 column 수만큼 반복해서 처리
//                    Cell cell = row.createCell(column); // cell 생성
//                    cell.setCellValue(data[rownum][column]); // cell에 값 쓰기
//                }
//            }
//
//            fos = new FileOutputStream("doc/POI-write.xlsx"); // file 생성
//            workbook.write(fos); // excel 저장
//        } finally {
//            if (fos != null) {
//                fos.close(); // file resource 반환
//            }
//            if (workbook != null) {
//                workbook.close(); // excel resource 반환
//            }
//        }
    }
}
