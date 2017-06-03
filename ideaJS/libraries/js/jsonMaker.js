var valueReturner = (function() {

    function randomText()
    {
        var text = "";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for( var i=0; i < 5; i++ )
            text += possible.charAt(Math.floor(Math.random() * possible.length));

        return text;
    }


    return {
        randomData : function (titleField, valueField) {

            var returnArray = [];

            for (i=1; i<=10; i++) {
                var object = {};
                object[titleField] = randomText();
                object[valueField] = Math.random()*10;
                returnArray.push(object)
            }

            return returnArray;
        }
    };


})();

var jsonMaker = (function() {

    return {
        pieData : function () {
            var obj = {"type": "pie"};

            obj.dataProvider = valueReturner.randomData("country", "litres");

            obj.titleField = "country";
            obj.valueField = "litres";
            obj.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";

            return obj;
        }
    };

})();