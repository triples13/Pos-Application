$(document).ready(function(){
	var i=0;
	var sum=0;
	
	$('body').one('click', 'input[id="calculateTotal"]', function(event){
		$("tr.item").each(function(){
	    	 sum=sum+parseInt($(this).find("td:nth-child(4)").text());
	    	 console.log(sum);
	    	 $("#total").html(sum);
	   })
	   
	})
	
	$('body').one('click', 'input[id="checkOut"]', function(event){
		window.location.href="/pos/confirmOrder";
	   })

	$("#submit").click(function(event){
		var barcode=$(this).closest("tr").find("td:nth-child(1)").text();
		var product=$(this).closest("tr").find("td:nth-child(2)").text();
		var price=$(this).closest("tr").find("td:nth-child(3)").text();
		var order={"barcodeid":barcode,"pname":product,"price":price,"qty":1}
		
		$.ajax({
			type:'POST',	
			url:'/pos/addproduct',
			dataType: "json",
			data:JSON.stringify(order),
			contentType: "application/json; charset=utf-8",
			success:
				function(data){
				 i++;
				 console.log(i);
				$.each(data,function(index,value){
					var temp = "qty" + data[index].barcodeid.trim();
					var qtyitm=$("#"+temp);
					
					if(qtyitm.length != 0){
						qtyitm.html(data[index].qty);
						//("#price"+(data[index].barcodeid.trim())).html(data[index].price);
						temp = "price" + data[index].barcodeid.trim();
						qtyitm = $("#"+temp);
						qtyitm.html(data[index].price);
					}
					else{
						var row=$('<tr class="item"><td>'+data[index].oid+"</td>"+"<td>"+data[index].pname.trim()+
								"</td>"+
								"<td id=\"qty"+data[index].barcodeid.trim()+"\">"+data[index].qty+"</td>"+
								"<td id=\"price"+data[index].barcodeid.trim()+"\">"+data[index].price+"</td>"+
								"<td>"
								+data[index].barcodeid.trim()+'</td></tr>'
							
						);
						$("#firstrow").after(row).removeClass("hidden");
						}
					
				})
				if(i==1){
					var url="/pos/confirmOrder";
				var row1=$("<tr>"+'<td><input type="submit" id="calculateTotal" value="Total"></td>'+
						'<td><td><td><div id="total"></div></td></td></td>'+"</tr>"+
						"<tr>"+'<td><input type="submit" id="checkOut" value="Do You Wish To CheckOut?"></td>'+"</tr>");
				$("#order tbody").append(row1);
				}
				
			}
		
	})
	});
	
	
})