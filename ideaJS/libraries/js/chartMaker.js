var helperClass = (function() {

    return {
        show : function (divName) {
            AmCharts.makeChart(divName, jsonMaker.pieData());
        }
    };

})()