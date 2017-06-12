$(document).ready(function() {
    $("#gastos").click(function(){
      //$('#container').load("show-gastos.jsp");
       $.get('GastosServlet',{ action: null }, function(data) {
    	   console.log(data);
    	   $('.container').html(data);         
    	});
    });

});
