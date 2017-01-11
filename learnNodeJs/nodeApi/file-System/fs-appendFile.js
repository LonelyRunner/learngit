var fs = require("fs");

/**
 * 追加文件的异步方法:fs.appendFile(fileName,data,options,callback)
 * fileName:文件名
 * data: 添加的数据 String或者Buffer
 * options: encoding;mode;flag
 * callback:function
 */
fs.appendFile('message.txt','data to append',function(err){
    if(err){
        console.info('append a file is fail');
    }
});

console.info("append a file success!");

//ex: fs.appendFile('message.txt','data to append','utf-8',function(err){});

/**
 * 追加文件的同步方法: fs.appendFileSync(fileName,data,options)
 * 释义同上
 */

