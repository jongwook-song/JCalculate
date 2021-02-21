var main = {
    init : function(){
        var _this = this;
        $('#cal-btn').on('click', function(){
            _this.cal();
        });

        $('.count-value').keydown(function(key) {
             if (key.keyCode == 13) {
                 _this.cal();
             }
         });

        $('#excel-export').on('click', function(){
            _this.excelExport();
        });
    },

    //엑셀 내보내기
    excelExport : function(){

        this.cal();

        var excelExportObject = new Object();

        excelExportObject.ppskirt = $("#ppskirt-value").text();
        excelExportObject.ppchop = $("#ppchop-value").text();
        excelExportObject.ppsirloin = $("#ppsirloin-value").text();
        excelExportObject.pptenderloin = $("#pptenderloin-value").text();
        excelExportObject.ppstriploin = $("#ppstriploin-value").text();
        excelExportObject.pprisket = $("#pprisket-value").text();
        excelExportObject.ppblade = $("#ppblade-value").text();
        excelExportObject.pskirt = $("#pskirt-value").text();
        excelExportObject.pchop = $("#pchop-value").text();
        excelExportObject.psirloin = $("#psirloin-value").text();
        excelExportObject.ptenderloin = $("#ptenderloin-value").text();
        excelExportObject.pstriploin = $("#pstriploin-value").text();
        excelExportObject.prisket = $("#prisket-value").text();
        excelExportObject.pblade = $("#pblade-value").text();
        excelExportObject.gchop = $("#gchop-value").text();
        excelExportObject.gsirloin = $("#gsirloin-value").text();
        excelExportObject.gtenderloin = $("#gtenderloin-value").text();
        excelExportObject.gstriploin = $("#gstriploin-value").text();
        excelExportObject.grisket = $("#grisket-value").text();
        excelExportObject.gblade = $("#gblade-value").text();
        excelExportObject.bulgogi = $("#bulgogi-value").text();
        excelExportObject.soup = $("#soup-value").text();
        excelExportObject.sanjuk = $("#sanjuk-value").text();
        excelExportObject.season = $("#season-value").text();
        excelExportObject.steam = $("#steam-value").text();

        console.log( excelExportObject);

//        $.ajax({
//            type: 'POST',
//            url: '/excel/export',
//            dataType: 'json',
//            contentType: 'application/json; charset=utf-8',
//            data: JSON.stringify( excelExportObject),
//        }).done(function( data){
//            alert('내보내기 완료');
//        }).fail(function (error){
//            alert('내보내기 실패');
//        });
        $.fileDownload("/excel/export", {
            httpMethod: "POST",
            data : excelExportObject,
            contentType: 'application/json; charset=utf-8',
            successCallback: function (url) {
                alert("성공");
            },
            failCallback: function (responseHtml, url) {
                alert("실패");
            }
        });
        // 버튼의 원래 클릭 이벤트를 중지 시키기 위해 필요합니다.
        return false;
    },

    // 계산 관련
    cal : function(){
        var ppskirt = 0; // 1++ 안창살
        var ppchop = 0; // 1++ 갈비살
        var ppsirloin = 0; // 1++ 등심
        var pptenderloin = 0; // 1++ 안심
        var ppstriploin = 0; // 1++ 채끝
        var pprisket = 0; // 1++ 업진
        var ppblade = 0; // 1++ 부채

        var pskirt = 0; // 1+ 안창살
        var pchop = 0; // 1+ 갈비살
        var psirloin = 0; // 1+ 등심
        var ptenderloin = 0; // 1+ 안심
        var pstriploin = 0; // 1+ 채끝
        var prisket = 0; // 1+ 업진
        var pblade = 0; // 1+ 부채

        var gchop = 0; // 1등급 갈비살
        var gsirloin = 0; // 1등급 등심
        var gtenderloin = 0; // 1등급 안심
        var gstriploin = 0; // 1등급 채끝
        var grisket = 0; // 1등급 업진
        var gblade = 0; // 1등급 부채

        var bulgogi = 0; // 불고기
        var soup = 0; // 국거리
        var sanjuk = 0; // 산적
        var season = 0; // 불고기 양념
        var steam = 0; // 찜갈비

        var count = 0; // 곱 카운터

        // 프리미엄1-1호
        count = $('#pre-input11').val();
        pskirt += 600*count; // 1+ 안창살
        pchop += 600*count; // 1+ 갈비살
        psirloin += 600*count; // 1+ 등심
        ptenderloin += 600*count; // 1+ 안심

        // 프리미엄1-2호
        count = $('#pre-input12').val();
        pskirt += 600*count; // 1+ 안창살
        pchop += 600*count; // 1+ 갈비살
        psirloin += 600*count; // 1+ 등심
        pstriploin += 600*count; // 1+ 채끝

        // 프리미엄2-1호
        count = $('#pre-input21').val();
        pchop += 600*count; // 1+ 갈비살
        psirloin += 600*2*count; // 1+ 등심
        ptenderloin += 600*count; // 1+ 안심

        // 프리미엄2-2호
        count = $('#pre-input22').val();
        pchop += 600*count; // 1+ 갈비살
        psirloin += 600*2*count; // 1+ 등심
        pstriploin += 600*count; // 1+ 채끝

        // 프리미엄3-1호
        count = $('#pre-input31').val();
        psirloin += 600*2*count; // 1+ 등심
        ptenderloin += 600*count; // 1+ 안심
        prisket += 600*count; // 1+ 업진

        // 프리미엄3-1호
        count = $('#pre-input32').val();
        psirloin += 600*2*count; // 1+ 등심
        pstriploin += 600*count; // 1+ 채끝
        pblade += 600*count; // 1+ 부채

        // 프리미엄4-1호
        count = $('#pre-input41').val();
        psirloin += 600*count; // 1+ 등심
        ptenderloin += 600*count; // 1+ 안심
        prisket += 600*count; // 1+ 업진
        pblade += 600*count; // 1+ 부채

        // 프리미엄4-2호
        count = $('#pre-input42').val();
        psirloin += 600*count; // 1+ 등심
        pstriploin += 600*count; // 1+ 채끝
        prisket += 600*count; // 1+ 업진
        pblade += 600*count; // 1+ 부채

        // 프리미엄5-1호
        count = $('#pre-input51').val();
        ppskirt += 600*count; // 1++ 안창살
        ppchop += 600*count; // 1++ 갈비살
        ppsirloin += 600*count; // 1++ 등심
        pptenderloin += 600*count; // 1++ 안심

        // 프리미엄5-2호
        count = $('#pre-input52').val();
        ppskirt += 600*count; // 1++ 안창살
        ppchop += 600*count; // 1++ 갈비살
        ppsirloin += 600*count; // 1++ 등심
        ppstriploin += 600*count; // 1++ 채끝

        // 프리미엄6-1호
        count = $('#pre-input61').val();
        ppchop += 600*count; // 1++ 갈비살
        ppsirloin += 600*2*count; // 1++ 등심
        pptenderloin += 600*count; // 1++ 안심

        // 프리미엄6-2호
        count = $('#pre-input62').val();
        ppchop += 600*count; // 1++ 갈비살
        ppsirloin += 600*2*count; // 1++ 등심
        ppstriploin += 600*count; // 1++ 채끝

        // 프리미엄7-1호
        count = $('#pre-input71').val();
        ppsirloin += 600*2*count; // 1++ 등심
        pptenderloin += 600*count; // 1++ 안심
        pprisket += 600*count; // 1++ 업진

        // 프리미엄7-1호
        count = $('#pre-input72').val();
        ppsirloin += 600*2*count; // 1++ 등심
        ppstriploin += 600*count; // 1++ 채끝
        ppblade += 600*count; // 1++ 부채

        // 프리미엄8-1호
        count = $('#pre-input81').val();
        ppsirloin += 600*count; // 1++ 등심
        pptenderloin += 600*count; // 1++ 안심
        pprisket += 600*count; // 1++ 업진
        ppblade += 600*count; // 1++ 부채

        // 프리미엄8-2호
        count = $('#pre-input82').val();
        ppsirloin += 600*count; // 1++ 등심
        ppstriploin += 600*count; // 1++ 채끝
        pprisket += 600*count; // 1++ 업진
        ppblade += 600*count; // 1++ 부채

        // 로스 1-1호
        count = $('#ros-input11').val();
        gsirloin += 600*count; // 1등급 등심
        gtenderloin += 600*count; // 1등급 안심
        gblade += 600*count; // 1등급 부채

        // 로스 1-2호
        count = $('#ros-input12').val();
        gsirloin += 600*count; // 1등급 등심
        gstriploin += 600*count; // 1등급 채끝
        grisket += 600*count; // 1등급 업진

        // 로스 2-1호
        count = $('#ros-input21').val();
        gchop += 600*count; // 1등급 갈비살
        gsirloin += 600*2*count; // 1등급 등심
        gtenderloin += 600*count; // 1등급 안심
        gblade += 600*count; // 1등급 부채

        // 로스 2-2호
        count = $('#ros-input22').val();
        gchop += 600*count; // 1등급 갈비살
        gsirloin += 600*2*count; // 1등급 등심
        gstriploin += 600*count; // 1등급 채끝
        grisket += 600*count; // 1등급 업진

        // 로스 3-1호
        count = $('#ros-input31').val();
        gsirloin += 600*2*count; // 1등급 등심
        gtenderloin += 600*count; // 1등급 안심
        gblade += 600*count; // 1등급 부채

        // 로스 3-2호
        count = $('#ros-input32').val();
        gsirloin += 600*2*count; // 1등급 등심
        gstriploin += 600*count; // 1등급 채끝
        grisket += 600*count; // 1등급 업진

        // 알뜰 1호
        count = $('#thrift-input1').val();
        bulgogi += 600*2*count; // 불고기
        soup += 600*count; // 국거리
        sanjuk += 600*count; // 산적
        season += 2*count; // 불고기 양념

        // 알뜰 2호
        count = $('#thrift-input2').val();
        bulgogi += 600*count; // 불고기
        soup += 600*count; // 국거리
        sanjuk += 600*count; // 산적
        season += 2*count; // 불고기 양념

        // 찜갈비
        count = $('#steam-input1').val();
        steam += 4*count; // 찜갈비

        // 혼합 1호
        count = $('#mix-input1').val();
        gsirloin += 600*count; // 1등급 등심
        bulgogi += 600*2*count; // 불고기
        season += 2*count; // 불고기 양념

        // 혼합 2호
        count = $('#mix-input2').val();
        gsirloin += 600*count; // 1등급 등심
        bulgogi += 600*count; // 불고기
        soup += 600*count; // 국거리

        // 혼합 3-1호
        count = $('#mix-input31').val();
        gsirloin += 600*count; // 1등급 등심
        gtenderloin += 600*count; // 1등급 안심
        bulgogi += 600*count; // 불고기
        soup += 600*count; // 국거리

        // 혼합 3-2호
        count = $('#mix-input32').val();
        gsirloin += 600*count; // 1등급 등심
        gstriploin += 600*count; // 1등급 채끝
        bulgogi += 600*count; // 불고기
        soup += 600*count; // 국거리

        // 혼합 4-1호
        count = $('#mix-input41').val();
        gsirloin += 600*count; // 1등급 등심
        gtenderloin += 600*count; // 1등급 안심
        bulgogi += 600*2*count; // 불고기

        // 혼합 4-2호
        count = $('#mix-input42').val();
        gsirloin += 600*count; // 1등급 등심
        gstriploin += 600*count; // 1등급 채끝
        bulgogi += 600*2*count; // 불고기

        ppskirt = ppskirt/1000;
        ppchop = ppchop/1000;
        ppsirloin = ppsirloin/1000;
        pptenderloin = pptenderloin/1000;
        ppstriploin = ppstriploin/1000;
        pprisket = pprisket/1000;
        ppblade = ppblade/1000;
        pskirt = pskirt/1000;
        pchop = pchop/1000;
        psirloin = psirloin/1000;
        ptenderloin = ptenderloin/1000;
        pstriploin = pstriploin/1000;
        prisket = prisket/1000;
        pblade = pblade/1000;
        gchop = gchop/1000;
        gsirloin = gsirloin/1000;
        gtenderloin = gtenderloin/1000;
        gstriploin = gstriploin/1000;
        grisket = grisket/1000;
        gblade = gblade/1000;
        bulgogi = bulgogi/1000;
        soup = soup/1000;
        sanjuk = sanjuk/1000;

        $("#ppskirt-value").text(ppskirt);
        $("#ppchop-value").text(ppchop);
        $("#ppsirloin-value").text(ppsirloin);
        $("#pptenderloin-value").text(pptenderloin);
        $("#ppstriploin-value").text(ppstriploin);
        $("#pprisket-value").text(pprisket);
        $("#ppblade-value").text(ppblade);
        $("#pskirt-value").text(pskirt);
        $("#pchop-value").text(pchop);
        $("#psirloin-value").text(psirloin);
        $("#ptenderloin-value").text(ptenderloin);
        $("#pstriploin-value").text(pstriploin);
        $("#prisket-value").text(prisket);
        $("#pblade-value").text(pblade);
        $("#gchop-value").text(gchop);
        $("#gsirloin-value").text(gsirloin);
        $("#gtenderloin-value").text(gtenderloin);
        $("#gstriploin-value").text(gstriploin);
        $("#grisket-value").text(grisket);
        $("#gblade-value").text(gblade);
        $("#bulgogi-value").text(bulgogi);
        $("#soup-value").text(soup);
        $("#sanjuk-value").text(sanjuk);
        $("#season-value").text(season);
        $("#steam-value").text(steam);

    }
};
main.init();