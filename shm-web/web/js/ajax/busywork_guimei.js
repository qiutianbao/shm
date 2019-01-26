// JavaScript Document

/*加入收藏夹*/
function addCookie(){
    if(document.all){
        window.external.addFavorite('http://www.gmgw.com','贵美商城');
    }
    else if(window.sidebar){
        window.sidebar.addPanel('贵美商城','http://www.gmgw.com','');
    }
}

/*设为首页*/
function setHomePages(){
    /*if(document.all){*/
    document.documentElement.style.behavior="url(#default#homepage)";
    document.documentElement.setHomePage('http://www.gmgw.com');
}

/*屏蔽右键功能*/
function click(){
    alert('对不起，不能单击右键！')  //点击右键时，弹出警告框，屏蔽右键
    return false;
}
document.oncontextmenu=click;


/*网页头部的时间及问候语*/
function time(){
    var header_middle=document.getElementById("header_middle");
    header_middle.innerHTML="你好，欢迎访问贵美商城！";
    now=new Date;
    var year=now.getFullYear()+"年";
    var month=(now.getMonth()+1)+"月";
    var day=now.getDate()+"日";
    var hour=now.getHours()+"点";
    var minutes=now.getMinutes()+"分"
    header_middle.innerHTML+=year+month+day+hour+minutes;
}


/*左侧菜单*/
function menu(){
    var menu=new Array();
    menu["家用电器"]=["大家电","洗衣机","平板电视","电热水器","家庭音响","热水器","空调冰箱","冷柜","DVD","电视附件","电燃气","家电下乡","家电服务","电饭煲","摄像机"];
    menu["书籍"]=["文学","科普","保健","家教","美丽生活","旅游","体育","个人理财","地图","生活","文化","历史","哲学","宗教","法律"];
    menu["手机数码"]=["电脑整机","网络设备","DIY配件","GSM手机","CDMA","联通3G","电信3G","移动3G","电话机","对讲机","电脑桌","电脑包","键盘","鼠标","网线"];
    menu["日用百货"]=["儿童床品","枕巾","浴巾","春秋被","床单","工艺摆设","装饰画","家居清洁","衣物整理","眼罩","指甲刀","字画","日用礼品","常备药品","减肥"];
    var cat_menu=document.getElementById("cat_menu");
    cat_menu.innerHTML="";
    for(var i in menu){
        var title="<li class='cat_class'>"+i+"</li>";
        cat_menu.innerHTML+=title;
        for(var j in menu[i]){
            var title_menu="<li class='cat_li'>"+menu[i][j]+"</li>";
            cat_menu.innerHTML+=title_menu;
        }
    }
}


/*图片轮换显示的广告*/
var NowFrame = 1;   //最先显示第一张图片
var MaxFrame = 4;   //一共五张图片
function adver(d1) {
    if(Number(d1)){
        clearTimeout(theTimer);  //当触动按扭时，清除计时器
        NowFrame=d1;                //设当前显示图片
    }
    for(var i=1;i<(MaxFrame+1);i++){
        if(i==NowFrame){
            document.getElementById("adverImg").src ="images/guimei/guimei_ad-0"+i+".jpg";   //显示当前图片
        }
    }
    if(NowFrame == MaxFrame){   //设置下一个显示的图片
        NowFrame = 1;
    }
    else{
        NowFrame++;
    }
}
var theTimer=setInterval('adver()', 3000);   //设置定时器，显示下一张图片
window.onload=adver;    //页面加载时运行函数adver()



/*笔记本、手机充值TAB切换*/
function change(ss){
    if(ss=="top1"){
        document.getElementById("left1").style.display="block";
        document.getElementById("left2").style.display="none";
        document.getElementById("right1").style.display="block";
        document.getElementById("right2").style.display="none";
        document.getElementById("end1").style.display="block";
        document.getElementById("end2").style.display="none";
    }
    else{
        document.getElementById("left1").style.display="none";
        document.getElementById("left2").style.display="block";
        document.getElementById("right1").style.display="none";
        document.getElementById("right2").style.display="block";
        document.getElementById("end1").style.display="none";
        document.getElementById("end2").style.display="block";
    }
}


/*漂浮广告*/
//定义全局变量
var moveX = 0;       //X轴方向移动的距离
var moveY = 0;      //Y轴方向移动的距离
var step = 1;      //图片移动的速度
var directionY = 0;   //设置图片在Y轴的移动方向
var directionX = 0;   //设置图片在X轴的移动方向              

function changePos(){
    var img = document.getElementById("float");  //图片所在层ID
    var width = document.documentElement.clientWidth;       //浏览器宽度
    var height = document.documentElement.clientHeight;    //浏览器高度
    var imgHeight=document.getElementById("floatImg").height;   //漂浮图片高度
    var imgWidth=document.getElementById("floatImg").width;     //漂浮图片宽度
    img.style.left =parseInt(moveX + document.documentElement.scrollLeft)+"px";     //漂浮图片距浏览器左侧位置
    img.style.top = parseInt(moveY + document.documentElement.scrollTop)+"px";      //漂浮图片距浏览器顶端位置
//alert(img.style.left);
    if (directionY==0){
        moveY = moveY + step;   //漂浮图片在Y轴方向上向下移动
    }
    else{
        moveY = moveY - step;   //漂浮图片在Y轴方向上向上移动
    }
    if (moveY < 0) {     //如果漂浮图片漂到浏览器顶端时，设置图片在Y轴方向上向下移动
        directionY = 0;
        moveY = 0;
    }
    if (moveY >= (height - imgHeight)) {   //如果漂浮图片漂到浏览器底端时，设置图片在Y轴方向上向上移动
        directionY = 1;
        moveY = (height - imgHeight);
    }
    if (directionX==0){
        moveX = moveX + step;     //漂浮图片在X轴方向上向右移动
    }
    else {
        moveX = moveX - step;     //漂浮图片在X轴方向上向左移动
    }
    if (moveX < 0) {     //如果漂浮图片漂到浏览器左侧时，设置图片在X轴方向上向右移动
        directionX = 0;
        moveX = 0;
    }
    if (moveX >= (width - imgWidth)) {     //如果漂浮图片漂到浏览器右侧时，设置图片在X轴方向上向左移动
        directionX = 1;
        moveX = (width - imgWidth);
    }
    // setTimeout("changePos()",30);
}
setInterval("changePos()",30); 

