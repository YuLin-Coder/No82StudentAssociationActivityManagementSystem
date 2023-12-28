$("document").ready(function(){
	$(".nav > li").hover(function(){
		$(this).addClass("on");
	    $(this).children("div").stop(true,true).slideDown("fast");
	},function(){
	    $(this).removeClass("on");
		$(this).children("div").stop(true,true).slideUp("fast");
	})
    $("#navChild a:last-child ").css("border-bottom","none") 

  var colorList,length,i;
  colorList = ['#606060','#787878','#8c8c8c','#9d9d9d','#b4b4b4','#ccc','#555555','#336667'];
  length = $(".claListUlList li").length;
  for(i=0;i<length;i++){
     $(".claListUlList li").eq(i).find("a").css("background",colorList[i]);	
  }
  
  $(".casePicUl li").hover(function(){
  	$(this).find(".more a").css({"color":"#b02a28","background":"#fff"})
  },function(){
  		$(this).find(".more a").css({"color":"#ffffff","background":"#a9a9a9"})
  })

   $('.backTop').click(function(){
		$('body,html').animate({scrollTop:0},500)
	});
   $('.codepic').hover(function(){$('.code').fadeIn()},function(){$('.code').fadeOut()});
	$('.backup').click(function(){
		$('body,html').animate({scrollTop:0},500)
	});
	$(".backup").hide();
	$(function() {
		$(window).scroll(function(){
			if ($(window).scrollTop()>500){
				$(".backup").fadeIn(1000);
			}else{
				$(".backup").fadeOut(1000);
			}
		});
	});
	
	
	$(".serviceTel .close").click(function(){
		$(".serviceTel").css("display","none");
	})
/* end index  jq  */
   
   $(".leftProClaListUl > li:last-child").css("border-bottom","none");
   $(".leftProClaListUl > li").click(function(){
   		$(this).next("ul").slideToggle();
   })
   
 
  
  $(".leftNewsUl li:last-child").css("border-bottom","none");
   
   
   
 	
   $(".mainConList .pic11:nth-child(3n)").css("margin-right","0px");  
   
    $(".mainConList .pic11").hover(function(){
	  	 var $abc = $(this);
	  	 $abc.find(".title").stop(true,true).slideUp("fast",function(){$abc.find(".intro").slideDown("fast");})  
	},function(){
	  	 var $abc = $(this);
	  	 $abc.find(".title").stop(true,true);
	     $abc.find(".intro").stop(true,true).slideUp("fast",function(){$abc.find(".title").slideDown("fast");})
	})

   $(".mainContect .pgfyl p:first-child").css("border-left","none");
  
});


 $(function(){
				 var nav=$(".navgrp");
				 var win=$(window);
				 var sc=$(document);
				 win.scroll(function(){
				 	if(sc.scrollTop()>=139){
				 		nav.addClass("fixednav");
					}else{
						nav.removeClass("fixednav");
					}
				})
				
			    var urlstr = location.href;
				var d = document.getElementsByClassName("navgrp")[0].getElementsByTagName("li"); // 获取所有li元素
				var s = location.href.substring(location.href.lastIndexOf('/') +1, location.href.indexOf('.'));
			    for(var i=0; i<d.length; i++){			    
				    if (d[i].innerHTML.includes(s)) {
				    	d[i].className="cur";
				    } else {
				    	d[i].className="";
				    }	                
			    }
			})