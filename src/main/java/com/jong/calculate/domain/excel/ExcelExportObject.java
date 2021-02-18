package com.jong.calculate.domain.excel;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExcelExportObject {
    private int setOneValue;
    private int setTwoValue;
    private int sirloin; // 등심 1 2
    private int bulgogi; //불고기 1
    private int jangjorim; //장조림 1
    private int soupStock; //국거리 1
    private int relief; //안심 2
    private int chop; //채끝 2

    @Builder
    public ExcelExportObject( int setOneValue, int setTwoValue, int sirloin, int bulgogi, int jangjorim, int soupStock,
                           int relief, int chop){
        this.setOneValue = setOneValue;
        this.setTwoValue = setTwoValue;
        this.sirloin = sirloin;
        this.bulgogi = bulgogi;
        this.jangjorim = jangjorim;
        this.soupStock = soupStock;
        this.relief = relief;
        this.chop = chop;
    }

}
