var jsonMaker = (function() {

    return {
        pieData : function () {
            var obj = {"type": "pie"};

            obj.dataProvider = [{
                "country": "Czech Republic",
                "litres": 156.9
            }, {
                "country": "Ireland",
                "litres": 131.1
            }
            ];

            obj.titleField = "country";
            obj.valueField = "litres";
            obj.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
            obj.legend = {
                "align": "center",
                "markerType": "circle"
            };

            return obj;
        }
    };


})()