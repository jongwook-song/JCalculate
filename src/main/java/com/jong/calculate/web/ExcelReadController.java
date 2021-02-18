package com.jong.calculate.web;

import com.jong.calculate.domain.excel.ExcelExportObject;
import com.jong.calculate.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExcelReadController {

    private final ExcelService excelService;

    @PostMapping("/excel/export")
    public void excelExport(@RequestBody ExcelExportObject excelExportObject) throws Exception {
        excelService.excelExport( excelExportObject);
    }

}
