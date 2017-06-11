package com.grupo4.independenciaFinanciera.charts;

public class ChartTablero implements ChartData {

    private float income;
    private float expenses;
    private float total;

    public ChartTablero() {
        this.income = incomeValue();
        this.expenses = expensesValue();
        this.total = income + expenses;
    }


    //@Override
    public String getData() {
        return "\t\t\t\t{\n" +
                "\t\t\t\t\t\"type\": \"serial\",\n" +
                "\t\t\t\t\t\"categoryField\": \"category\",\n" +
                "\t\t\t\t\t\"rotate\": true,\n" +
                "\t\t\t\t\t\"startDuration\": 1,\n" +
                "\t\t\t\t\t\"categoryAxis\": {\n" +
                "\t\t\t\t\t\t\"gridPosition\": \"start\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"trendLines\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"id\": \"TrendLine-1\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"graphs\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"balloonText\": \"[[title]] of [[category]]:[[value]]\",\n" +
                "\t\t\t\t\t\t\t\"fillAlphas\": 1,\n" +
                "\t\t\t\t\t\t\t\"fillColors\": \"#5FC00B\",\n" +
                "\t\t\t\t\t\t\t\"id\": \"AmGraph-1\",\n" +
                "\t\t\t\t\t\t\t\"lineColor\": \"#5FC00B\",\n" +
                "\t\t\t\t\t\t\t\"title\": \"graph 1\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"column\",\n" +
                "\t\t\t\t\t\t\t\"valueField\": \"column-1\",\n" +
                "\t\t\t\t\t\t\t\"visibleInLegend\": false\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"balloonText\": \"[[title]] of [[category]]:[[value]]\",\n" +
                "\t\t\t\t\t\t\t\"fillAlphas\": 1,\n" +
                "\t\t\t\t\t\t\t\"fillColors\": \"#ED1313\",\n" +
                "\t\t\t\t\t\t\t\"id\": \"AmGraph-2\",\n" +
                "\t\t\t\t\t\t\t\"lineColor\": \"#ED1313\",\n" +
                "\t\t\t\t\t\t\t\"title\": \"graph 2\",\n" +
                "\t\t\t\t\t\t\t\"type\": \"column\",\n" +
                "\t\t\t\t\t\t\t\"valueField\": \"column-2\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"guides\": [],\n" +
                "\t\t\t\t\t\"valueAxes\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"id\": \"ValueAxis-1\",\n" +
                "\t\t\t\t\t\t\t\"stackType\": \"100%\",\n" +
                "\t\t\t\t\t\t\t\"gridColor\": \"#CC2525\",\n" +
                "\t\t\t\t\t\t\t\"title\": \"\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"id\": \"ValueAxis-2\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"allLabels\": [],\n" +
                "\t\"titles\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": \"Title-1\",\n" +
                "\t\t\t\"size\": 15,\n" +
                "\t\t\t\"text\": \"Mi posición Actual es: $" + this.total + "\"\n" +
                "\t\t}\n" +
                "\t],"+
                "\t\t\t\t\t\"balloon\": {},\n" +
                "\t\t\t\t\t\"dataProvider\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"category\": \"\",\n" +
                "\t\t\t\t\t\t\t\"column-1\": " + this.income + " ,\n" +
                "\t\t\t\t\t\t\t\"column-2\": " + this.expenses + "\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t\t}";
    }

    private float incomeValue() {
        //TODO get it from database
        return 32000;
    }

    private float expensesValue() {
        //TODO get it from database
        return 8000;
    }
}
