var helperClass = (function() {
    var divName = "chartdiv";

    return {
        show : function () {
            AmCharts.makeChart(divName, jsonMaker.pieData());
        }
    };


})()