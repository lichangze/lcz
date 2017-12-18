	
function validateMethod(id,meessage){
	if($("#"+id).val()=='undefined' && $("#"+id).val() == ''){
      		$("#"+id).val(meessage);
      		$("#"+id).css('color','red');
      $("#"+id).focus(function(event) {
         	$("#"+id).val('');
         	$("#"+id).css('color','#333');
     });
     }
	}
