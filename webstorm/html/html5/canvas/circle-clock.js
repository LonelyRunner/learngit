var circle = document.getElementById("clock");
var ctx = circle.getContext('2d');

var width = ctx.canvas.width;
var height = ctx.canvas.height;
var r = width / 2;

function drawBackground(){
    ctx.save();
    //移动圆心到div的中心
    ctx.translate(r,r);
    ctx.beginPath();
    //弧线宽度
    ctx.lineWidth = 10;
    //画圆 参数圆心坐标x,圆心坐标y,半径r,起始弧度start,结束弧度end,是否顺时针
    ctx.arc(0,0,r-5,0,2*Math.PI,true);
    ctx.stroke();

    var hourNumbers = [3,4,5,6,7,8,9,10,11,12,1,2];
    ctx.font = '18px Arial';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    hourNumbers.forEach(function(number,index){
        var rad = 2 * Math.PI / 12 * index;
        //计算每个时间点对应的x坐标
        var x = (r-30) * Math.cos(rad);
        //计算每个时间点对应的y坐标
        var y = (r-30) * Math.sin(rad);
        ctx.fillText(number,x,y);
    });

    for(var i=0;i<60;i++){
        var rad = 2 * Math.PI / 60 * i;
        //计算每个分钟点对应的x坐标
        var x = (r-18) * Math.cos(rad);
        //计算每个分钟点对应的y坐标
        var y = (r-18) * Math.sin(rad);
        ctx.beginPath();
        if(i%5===0){
            ctx.fillStyle = '#000';
            ctx.arc(x,y,2,0,2*Math.PI,false);
        }else{
            ctx.fillStyle = '#ccc';
            ctx.arc(x,y,2,0,2*Math.PI,false);
        }
        ctx.fill();
    }
}

//画时针
function drawHour(hour,minute,second){
    ctx.save();
    ctx.beginPath();
    var rad = 2*Math.PI/12*hour;
    var mRad = 2*Math.PI/12/60*minute;
    var sRad = 2*Math.PI/12/60/60*second;
    //旋转角度
    ctx.rotate(rad+mRad+sRad);
    ctx.lineCap = 'round';
    ctx.lineWidth = 6;
    ctx.moveTo(0,10);
    ctx.lineTo(0,-r/2);
    ctx.stroke();
    ctx.restore();
}

//画分针
function drawMinute(minute,second){
    //保存当前画布状态
    ctx.save();
    ctx.beginPath();
    var rad = 2*Math.PI/60*minute;
    var sRad = 2*Math.PI/60/60*second;
    //旋转角度
    ctx.rotate(rad+sRad);
    ctx.lineCap = 'round';
    ctx.lineWidth = 4;
    ctx.moveTo(0,10);
    ctx.lineTo(0,-r/2-r/6);
    ctx.stroke();
    //还原画布状态
    ctx.restore();
}

//画秒针
function drawSecond(second){
    ctx.save();
    ctx.beginPath();
    ctx.fillStyle = "#c14543";
    var rad = 2*Math.PI/60*second;
    //旋转角度
    ctx.rotate(rad);
    ctx.lineWidth = 2;
    ctx.moveTo(-2,20);
    ctx.lineTo(2,20);
    ctx.lineTo(1,-r+18);
    ctx.lineTo(-1,-r+18);
    ctx.fill();
    ctx.restore();
}

//画原点
function drawDot(){
    ctx.beginPath();
    ctx.fillStyle = "white";
    ctx.arc(0,0,5,0,2*Math.PI,false);
    ctx.stroke();
}


activate();

function activate(){
    var date = new Date();
    ctx.clearRect(0,0,width,height);
    drawBackground();
    drawHour(date.getHours(),date.getMinutes(),date.getSeconds());
    drawMinute(date.getMinutes(),date.getSeconds());
    drawSecond(date.getSeconds());
    drawDot();
    ctx.restore();
}

setInterval(activate,1000);