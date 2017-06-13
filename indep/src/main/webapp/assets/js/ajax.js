$(document).ready(function() {
    $("#listGastos").click(function(){
      //$('#container').load("show-gastos.jsp");
       $.get('./listGasto',{ action: null }, function(data) {
    	   console.log(data);
    	   $('.container').html(data);         
    	});


    });

});
