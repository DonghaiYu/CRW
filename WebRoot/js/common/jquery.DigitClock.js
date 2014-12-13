/**
 * @author Mr.Tu
 * http://www.loveweb8.com/
 *
 * Version 1.0
 * Copyright (c) 2014 我爱Web吧
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/mit-license.php
 */
	
(function($) {

    var _options = {};

	jQuery.fn.DigitClock = function(options) {
		_options = $.extend({}, $.fn.DigitClock.defaults, options);
		
		showClock($(this), _options);
		
		function showClock(obj, _options)
		{
			var date = new Date;
			var y = date.getFullYear();
			var M = date.getMonth()+1;
			var d = date.getDate();
			var h = date.getHours();
			var m = date.getMinutes();
			var s = date.getSeconds();
			var ampm = "";
			
			// 判断是否修改成AM、PM
			if (_options.bAmPm)
			{
				if (h>12)
				{
					h = h-12;
					ampm = " PM";
				}
				else
				{
					ampm = " AM";
				}
			}
			
			var templateStr = _options.timeFormat + ampm;
			templateStr = templateStr.replace("yyyy", format(y)).replace("MM", format(M)).replace("dd", format(d))
						  .replace("HH", format(h)).replace("mm", format(m)).replace("ss", format(s));
						  
			// 修改样式
			obj.css("fontSize", _options.fontSize);
			obj.css("fontFamily", _options.fontFamily);
			obj.css("color", _options.fontColor);
			obj.css("background", _options.background);
			obj.css("fontWeight", _options.fontWeight);
		
			// 将时间赋值给对象
			obj.html(templateStr)
			
			// 显示心跳
			if (_options.bShowHeartBeat)
			{
				$("label", obj).fadeTo(800, 0.1);
			}
			setTimeout(function(){showClock(obj, _options)}, 1000);
		}
		
		// 格式化时间
		function format(value){
			return (value < 10) ? ("0"+value) :value;
		}
	}
	
	// 默认值
	jQuery.fn.DigitClock.defaults = {
		fontSize: '50px',
		fontFamily: 'Microsoft JhengHei, Arial',
		fontColor: '#ff2200',
		fontWeight: 'bold',
		background: '#fff',
		timeFormat: 'yyyy-MM-dd HH<label>:</label>mm<label>:</label>ss ',
		bShowHeartBeat: false,
		bAmPm:false
	};

})(jQuery);

