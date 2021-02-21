package com.jong.calculate.service;

import com.jong.calculate.domain.excel.ExcelExportObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class ExcelService {

    public static String PPLUS      = "1++";
    public static String PLUS       = "1+";
    public static String GRADE      = "1등급";

    public static String SKIRT      =  " 안창살";
    public static String CHOP	    =  " 갈비살";
    public static String SIRLOIN	=  " 등심";
    public static String TENDERLOIN	=  " 안심";
    public static String STRIPLOIN	=  " 채끝";
    public static String RISKET	    =  "업진";
    public static String BLADE	    =  "부채";

    public static String BULGOGI	=  "불고기";
    public static String SOUP	    =  "국거리";
    public static String SANJUK	    =  "산적";
    public static String SEASON	    =  "불고기 양념";
    public static String STEAM	    =  "찜갈비";

    public void excelExport(ExcelExportObject excelExportObject, HttpServletResponse response) throws Exception{

        SXSSFWorkbook workbook = null;
        SXSSFRow row = null;
        SXSSFCell cell = null;
        CellStyle styleMoneyFormat = null;

        String[] cellHeader = {"1++ 부위", "Kg", "1+", "Kg", "1등급", "Kg", "기타", "Kg or 개"};

        int index = 0;
        int rowIndex = 1;

        try{
            workbook = new SXSSFWorkbook();

            SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("이름없음");
            sheet.setRandomAccessWindowSize(100);

            row = sheet.createRow(0);

            styleMoneyFormat = workbook.createCellStyle();
            CreationHelper ch = workbook.getCreationHelper();
            styleMoneyFormat.setDataFormat(ch.createDataFormat().getFormat("#,##0")); // 헤더 적용
            for(String head : cellHeader ) {
                cell = row.createCell(index++);
                cell.setCellValue(head);
            }

            // 2행
            row = sheet.createRow(1);
            // 1++ 갈비살
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+CHOP);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPpchop());
            // 1+ 갈비살
            cell = row.createCell(2);
            cell.setCellValue( PLUS+CHOP);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPchop());
            // 1등급 갈비살
            cell = row.createCell(4);
            cell.setCellValue( GRADE+CHOP);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGchop());
            // 기타 불고기
            cell = row.createCell(6);
            cell.setCellValue( BULGOGI);
            cell = row.createCell(7);
            cell.setCellValue( excelExportObject.getBulgogi());

            // 3행
            row = sheet.createRow(2);
            // 1++ 등심
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+SIRLOIN);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPpsirloin());
            // 1+ 등심
            cell = row.createCell(2);
            cell.setCellValue( PLUS+SIRLOIN);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPsirloin());
            // 1등급 등심
            cell = row.createCell(4);
            cell.setCellValue( GRADE+SIRLOIN);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGsirloin());
            // 기타 국거리
            cell = row.createCell(6);
            cell.setCellValue( SOUP);
            cell = row.createCell(7);
            cell.setCellValue( excelExportObject.getSoup());

            // 4행
            row = sheet.createRow(3);
            // 1++ 안심
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+TENDERLOIN);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPptenderloin());
            // 1+ 안심
            cell = row.createCell(2);
            cell.setCellValue( PLUS+TENDERLOIN);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPtenderloin());
            // 1등급 안심
            cell = row.createCell(4);
            cell.setCellValue( GRADE+TENDERLOIN);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGtenderloin());
            // 기타 산적
            cell = row.createCell(6);
            cell.setCellValue( SANJUK);
            cell = row.createCell(7);
            cell.setCellValue( excelExportObject.getSanjuk());

            // 5행
            row = sheet.createRow(4);
            // 1++ 채끝
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+STRIPLOIN);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPpstriploin());
            // 1+ 채끝
            cell = row.createCell(2);
            cell.setCellValue( PLUS+STRIPLOIN);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPstriploin());
            // 1등급 채끝
            cell = row.createCell(4);
            cell.setCellValue( GRADE+STRIPLOIN);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGstriploin());
            // 기타 SEASON
            cell = row.createCell(6);
            cell.setCellValue( SEASON);
            cell = row.createCell(7);
            cell.setCellValue( excelExportObject.getSeason());

            // 6행
            row = sheet.createRow(5);
            // 1++ 업진
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+RISKET);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPprisket());
            // 1+ 업진
            cell = row.createCell(2);
            cell.setCellValue( PLUS+RISKET);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPrisket());
            // 1등급 업진
            cell = row.createCell(4);
            cell.setCellValue( GRADE+RISKET);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGrisket());
            // 기타 찜갈비
            cell = row.createCell(6);
            cell.setCellValue( STEAM);
            cell = row.createCell(7);
            cell.setCellValue( excelExportObject.getSteam());

            // 7행
            row = sheet.createRow(6);
            // 1++ 부채
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+BLADE);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPpblade());
            // 1+ 부채
            cell = row.createCell(2);
            cell.setCellValue( PLUS+BLADE);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPblade());
            // 1등급 부채
            cell = row.createCell(4);
            cell.setCellValue( GRADE+BLADE);
            cell = row.createCell(5);
            cell.setCellValue( excelExportObject.getGblade());

            // 8행
            //SKIRT      =  " 안창살";
            row = sheet.createRow(7);
            // 1++ 안창살
            cell = row.createCell(0);
            cell.setCellValue( PPLUS+SKIRT);
            cell = row.createCell(1);
            cell.setCellValue( excelExportObject.getPskirt());
            // 1+ 안창살
            cell = row.createCell(2);
            cell.setCellValue( PLUS+SKIRT);
            cell = row.createCell(3);
            cell.setCellValue( excelExportObject.getPskirt());

            SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy_MM_dd_HH_mm_ss");

            Calendar time = Calendar.getInstance();

            String format_time1 = format1.format(time.getTime());

            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\""+format_time1+".xlsx\""));
            workbook.write(response.getOutputStream());

        }catch (Exception e){
            response.setHeader("Set-Cookie", "fileDownload=false; path=/");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Content-Type","text/html; charset=utf-8");

            OutputStream out = null;
            try {
                out = response.getOutputStream();
                byte[] data = new String("fail..").getBytes();
                out.write(data, 0, data.length);
            } catch(Exception ignore) {
                ignore.printStackTrace();
            } finally {
                if(out != null) try {
                    out.close();
                } catch(Exception ignore) {

                }
            }
        } finally {
            workbook.dispose();

            try {
                workbook.close();
            } catch(Exception ignore) {

            }
        }

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
//            String rootPath = System.getProperty("user.dir");
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
