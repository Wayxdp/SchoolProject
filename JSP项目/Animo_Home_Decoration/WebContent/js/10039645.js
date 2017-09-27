




















if(typeof doyoo=='undefined' || !doyoo){
var d_genId=function(){
    var id ='',ids='0123456789abcdef';
    for(var i=0;i<34;i++){ id+=ids.charAt(Math.floor(Math.random()*16));  }  return id;
};
var doyoo={
env:{
secure:false,
mon:'http://m2425.looyu.com/monitor',
chat:'http://looyuoms2431.looyu.com/chat',
file:'http://yun-static.soperson.com/131221',
compId:20000192,
confId:10039645,
vId:d_genId(),
lang:'',
fixFlash:1,
subComp:5418,
_mark:'f1c744ffdc95edd9c79ff52ef294daa3f23766f19e75b2b7fe4d28953d304e5cb03849ab2b51ba09'
}

, monParam:{
index:-1,
preferConfig:0,

style:{mbg:'http://jscss.dyrs.cc/icon/ly.png',mh:244,mw:433,
elepos:'0 0 0 0 0 0 0 0 148 44 132 37 380 220 28 28 307 116 94 31',
mbabg:'',
mbdbg:'',
mbpbg:''},

title:'',
text:'\u60a8\u597d\uff0c\u6b22\u8fce\u5149\u4e34\uff0c\u6211\u662f\u4eca\u5929\u7684\u5728\u7ebf\u670d\u52a1\u4eba\u5458\uff0c\u5f88\u9ad8\u5174\u4e3a\u60a8\u670d\u52a1!&nbsp;',
auto:1,
group:'10059956',
start:'00:00',
end:'24:00',
mask:false,
status:true,
fx:4,
mini:2,
pos:1,
offShow:0,
loop:10,
autoHide:0,
hidePanel:0,
miniStyle:'#ff5f53',
miniWidth:'340',
miniHeight:'490',
showPhone:0,
monHideStatus:[0,0,0],
monShowOnly:'',
autoDirectChat:2,
allowMobileDirect:0,
minBallon:1,
chatFollow:1
}




};

if(typeof talk99Init == 'function'){
    talk99Init(doyoo);
}
if(!document.getElementById('doyoo_panel')){
var supportJquery=typeof jQuery!='undefined';
var doyooWrite=function(html){
	document.writeln(html);
}

doyooWrite('<div id="doyoo_panel"></div>');


doyooWrite('<div id="doyoo_monitor"></div>');


doyooWrite('<div id="talk99_message"></div>')

doyooWrite('<div id="doyoo_share" style="display:none;"></div>');
doyooWrite('<lin'+'k rel="stylesheet" type="text/css" href="http://yun-static.soperson.com/131221/oms.css?170404"></li'+'nk>');
doyooWrite('<scr'+'ipt type="text/javascript" src="http://yun-static.soperson.com/131221/oms.js?170404" charset="utf-8"></scr'+'ipt>');
}
}
