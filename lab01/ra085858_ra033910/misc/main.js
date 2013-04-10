$(document).ready(function(){
     $('#titulos').css('display','none');
	 $('#titulos h1:last').attr('last','1');
	 $('#titulos h1').css('display','none');
	 $('#titulos h1:first').css('display','block');
	 $('#linkbar').html($('#titulos').html());
	 
	 $('.dialog').css('cursor','pointer');
	 $('.dialog').on('mouseover',function(){
		 $(this).css('text-decoration','underline');
	 });
	 $('.dialog').on('mouseout',function(){
		 $(this).css('text-decoration','none');
	 });
	 $('h1[class="dialog"], h3[class="dialog"]').on('click',function(){
			var id = '#'+$(this).attr('name');
			var $el = $(id);
			var tit = $(this).html();
			$el.dialog({
				autoOpen:true,
				modal:false,
				width:800,
				height:600,
				title:tit,
				buttons:{
					"Fechar":function(){
						$(this).dialog('close');
					}
				}
			});
		 });
	 
	 function InOut( elem ){
         elem.delay()
         .fadeIn()
         .delay('5000')
         .fadeOut(
             function(){
            	 if(elem.attr('last')=='1'){
            		 InOut( $('#linkbar h1:first') );
        		 }
            	 else
            		 InOut( elem.next() );
              }
         );
     }
	 InOut( $('#linkbar h1:first') );
});