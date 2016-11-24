//__filename:当前正在执行的脚本的文件名 将输出文件所在位置的绝对路径
console.info("__filename:"+__filename);
//__dirname:表示当前执行脚本所在的目录
console.info("__dirname:"+__dirname);

//setTimeout(callback,ms): 全局函数 在指定的ms数后执行callback。只执行一次。
var t = function(){
    console.info("我是setTimeout方法中的回调函数");
};
var a = setTimeout(t,2000);

//使用clearTimeout(a) 停止setTimeout指定的定时器

//setInterval(cb, ms):全局函数在指定的毫秒(ms)数后执行指定函数(cb)。
//返回一个代表定时器的句柄值。可以使用 clearInterval(t) 函数来清除定时器。


