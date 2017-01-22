var fs = require("fs");

/**
 *  fs.read(fd,buffer,offset,length,position,callback(err,byteRead,buff))
 *  该方法使用文件描述符来读取文件
 *  fd:通过fs.open()方法返回的文件描述符
 *  buffer:数据写入的缓存区
 *  offset:缓存区写入的写入偏移量
 *  length:要从文件中读取的字节数
 *  position:文件读取的起始位置，如果position为null则会从当前文件指针的位置读取
 *  callback: 有三个参数:err,byteRead,buffer
 *                      err为错误信息 byteRead表示读取的字节数 buffer为缓冲区对象
 */
var buf = new Buffer(1024);

fs.open('./sample.txt','r+',function(err,fd){
    if(err){ throw err;}
    fs.read(fd,buf,0,buf.length,0,function(err,bytes){
        if(err){ throw err;}
        console.info(bytes+" 字节被读取");
        if(bytes>0){
            console.info(buf.slice(0,bytes).toString());
        }
    });
});
