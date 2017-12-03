$(document).ready(function(){
	var ordersum=0;
	var barunit={};
	
	
	
	$("tr.orders").each(function(){
		var qty=$(this).find("td").find(".sp-quantity").find("input.quntity-input").val();
		var price=$(this).find("td:nth-child(4)").text();
		var barcode=$(this).find("td:nth-child(5)").text();
		var unitPrice=parseFloat(price)/parseFloat(qty);
		 barunit[barcode]=unitPrice;
		
	})
	
	$("tr.orders").each(function(){
		 ordersum=ordersum+parseInt($(this).find("td:nth-child(4)").text());
	
	})
	$("tr.total").each(function(){
		$(this).find("td:nth-child(4)").html(ordersum);
		
	})
	
	$(".ddd").on("click", function () {
		var newsum=0;
		var id = $(this).attr("id");
		var unitPrice=barunit[id]
		var newPrice;
		
	    var $button = $(this);
	    var oldValue = $button.closest('.sp-quantity').find("input.quntity-input").val();
	    
 	    if ($button.text() == "+") {
	        var newVal = parseFloat(oldValue) + 1;
	        newprice=parseFloat(unitPrice)*newVal;
	    } else {
	        // Don't allow decrementing below zero
	        if (oldValue > 0) {
	            var newVal = parseFloat(oldValue) - 1;
	            newprice=parseFloat(unitPrice)*newVal;
	        } else {
	            newVal = 0;
	        }
	        
	    }
 	   
 	 

	    $button.closest('.sp-quantity').find("input.quntity-input").val(newVal);
	    var temp="qty"+id;
	    
	    $("tr.orders").each(function(){
	    	if(temp==($(this).find("td:nth-child(4)").attr("id")))
	    		{
	    		$(this).find("td:nth-child(4)").html(newprice);
	    		}
			
		})
		$("tr.orders").each(function(){
		 newsum=newsum+parseInt($(this).find("td:nth-child(4)").text());
	
	})
		$("tr.total").each(function(){
		$(this).find("td:nth-child(4)").html(newsum);
		
	})
	  
	});
	$("#addProduct").on("click",function(){
		window.location.href="/pos/";
	})
	
})