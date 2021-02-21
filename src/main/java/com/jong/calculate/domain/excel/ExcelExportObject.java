package com.jong.calculate.domain.excel;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExcelExportObject {

    private String ppskirt; // 1++ 안창살
    private String ppchop; // 1++ 갈비살
    private String ppsirloin; // 1++ 등심
    private String pptenderloin; // 1++ 안심
    private String ppstriploin; // 1++ 채끝
    private String pprisket; // 1++ 업진
    private String ppblade; // 1++ 부채

    private String pskirt; // 1+ 안창살
    private String pchop; // 1+ 갈비살
    private String psirloin; // 1+ 등심
    private String ptenderloin; // 1+ 안심
    private String pstriploin; // 1+ 채끝
    private String prisket; // 1+ 업진
    private String pblade; // 1+ 부채

    private String gchop; // 1등급 갈비살
    private String gsirloin; // 1등급 등심
    private String gtenderloin; // 1등급 안심
    private String gstriploin; // 1등급 채끝
    private String grisket; // 1등급 업진
    private String gblade; // 1등급 부채

    private String bulgogi; // 불고기
    private String soup; // 국거리
    private String sanjuk; // 산적
    private String season; // 불고기 양념
    private String steam; // 찜갈비

    @Builder
    public ExcelExportObject( String ppskirt, String ppchop, String ppsirloin, String pptenderloin, String ppstriploin, String pprisket, String ppblade,
                              String pskirt, String pchop, String psirloin, String ptenderloin, String pstriploin, String prisket, String pblade,
                              String gchop, String gsirloin, String gtenderloin, String gstriploin, String grisket, String gblade,
                              String bulgogi, String soup, String sanjuk, String season, String steam){
        this.ppskirt = ppskirt;
        this.ppchop = ppchop;
        this.ppsirloin = ppsirloin;
        this.pptenderloin = pptenderloin;
        this.ppstriploin = ppstriploin;
        this.pprisket = pprisket;
        this.ppblade = ppblade;

        this.pskirt = pskirt;
        this.pchop = pchop;
        this.psirloin = psirloin;
        this.ptenderloin = ptenderloin;
        this.pstriploin = pstriploin;
        this.prisket = prisket;
        this.pblade = pblade;

        this.gchop = gchop;
        this.gsirloin = gsirloin;
        this.gtenderloin = gtenderloin;
        this.gstriploin = gstriploin;
        this.grisket = grisket;
        this.gblade = gblade;

        this.bulgogi = bulgogi;
        this.soup = soup;
        this.sanjuk = sanjuk;
        this.season = season;
        this.steam = steam;
    }

}
