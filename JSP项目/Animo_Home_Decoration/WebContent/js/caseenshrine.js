function enshrine(){
		$.post("/Animo_Home_Decoration/designer/designercollect",
				function (data) {
			if(data.info == '1'){
				layer.msg('已经收藏过！', {icon: 2,time: 3000});
				return;
			}
			if(data.info == '2'){
				layer.msg('收藏成功', {icon: 1,time: 3000});
				return;
		}
			}, "JSON");
	}