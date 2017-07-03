//������ style-my-tootltips �����: malihu (http://manos.malihu.gr)
//�������� �������� http://manos.malihu.gr/style-my-tooltips-jquery-plugin
(function($){  
 $.fn.style_my_tooltips = function(options) {  
	var defaults = {  
		tip_follows_cursor: "on", 
		tip_delay_time: 1000
	};
	var options = $.extend(defaults, options);
	$("body").append("<div id='s-m-t-tooltip'></div>"); //������� ��������� ��� ���������
	smtTip=$("#s-m-t-tooltip"); 
	smtTip.hide(); //�������� ���
    return this.each(function() {  
		function smtMouseMove(e){
			smtMouseCoordsX=e.clientX;
			smtMouseCoordsY=e.clientY;
			smtTipPosition();
		}
		function smtTipPosition(){
			var cursor_tip_margin_x=0;  //���������� �� ����������� ����� �������� � ����������
			var cursor_tip_margin_y=24; //���������� �� ��������� ����� �������� � ����������
			var leftOffset=smtMouseCoordsX+cursor_tip_margin_x+$(smtTip).outerWidth();
			var topOffset=smtMouseCoordsY+cursor_tip_margin_y+$(smtTip).outerHeight();
			if(leftOffset<=$(window).width()){
				smtTip.css("left",smtMouseCoordsX+cursor_tip_margin_x);
			} else {
				var thePosX=smtMouseCoordsX-(cursor_tip_margin_x)-$(smtTip).width();
				smtTip.css("left",thePosX);
			}
			if(topOffset<=$(window).height()){
				smtTip.css("top",smtMouseCoordsY+cursor_tip_margin_y);
			} else {
				var thePosY=smtMouseCoordsY-(cursor_tip_margin_y)-$(smtTip).height();
				smtTip.css("top",thePosY);
			}
		}
		$(this).hover(function(e) {  
			// ������ ���� ������� �� ������ � ����������
			var $this=$(this);
			$this.data("smtTitle",$this.attr("title")); 	//��������� ��������� 
			var theTitle=$this.data("smtTitle");
			$this.attr("title",""); 						//������� ���������, ����� ������������� ����� ��������� �� ���������
			smtTip.empty().append(theTitle).hide(); 		//������������� ����� ��������� � �������� ��
			smtTip_delay = setInterval(smtTip_fadeIn, options.tip_delay_time); //������������� �������� ������ ���������
			if(options.tip_follows_cursor=="off"){
				smtMouseMove(e);
			} else {
				$(document).bind("mousemove", function(event){
					smtMouseMove(event); 
				});
			}
		}, function() {  
			// ������ ���� �������� ������ � ����������
			var $this=$(this);
			if(options.tip_follows_cursor!="off"){
				$(document).unbind("mousemove");
			}
			clearInterval(smtTip_delay);
			if(smtTip.is(":animated")){ 
				smtTip.hide();
			} else {
				smtTip.fadeTo("fast",0);
			}
			$this.attr("title",$this.data("smtTitle")); //������������� ��������� �������
		});
		function smtTip_fadeIn(){
			smtTip.fadeTo("fast",1,function(){clearInterval(smtTip_delay);});
		}
	});  
 };  
})(jQuery);  