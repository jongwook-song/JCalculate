package com.jong.calculate.web;

import com.jong.calculate.domain.excel.ExcelExportObject;
import com.jong.calculate.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ExcelReadController {

    private final ExcelService excelService;
//@RequestParam Object param
//    @RequestBody ExcelExportObject excelExportObject
    @RequestMapping("/excel/export")
    public void excelExport(@RequestParam Map<Object, String> param, HttpServletResponse response) throws Exception {

        ExcelExportObject excelExportObject = ExcelExportObject.builder()
                .ppskirt( param.get("ppskirt"))
                .ppchop( param.get("ppchop"))
                .ppsirloin( param.get("ppsirloin"))
                .pptenderloin( param.get("pptenderloin"))
                .ppstriploin( param.get("ppstriploin"))
                .pprisket( param.get("pprisket"))
                .ppblade( param.get("ppblade"))
                .pskirt( param.get("pskirt"))
                .pchop( param.get("pchop"))
                .psirloin( param.get("psirloin"))
                .ptenderloin( param.get("ptenderloin"))
                .pstriploin( param.get("pstriploin"))
                .prisket( param.get("prisket"))
                .pblade( param.get("pblade"))
                .gchop( param.get("gchop"))
                .gsirloin( param.get("gsirloin"))
                .gtenderloin( param.get("gtenderloin"))
                .gstriploin( param.get("gstriploin"))
                .grisket( param.get("grisket"))
                .gblade( param.get("gblade"))
                .bulgogi( param.get("bulgogi"))
                .soup( param.get("soup"))
                .sanjuk( param.get("sanjuk"))
                .season( param.get("season"))
                .steam( param.get("steam"))
                .build();

        excelService.excelExport( excelExportObject, response);
    }

}
