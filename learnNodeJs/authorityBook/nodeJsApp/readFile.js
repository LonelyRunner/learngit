//node.js用异步的方式读取一个文件
var fs = require('fs');
fs.readFile('file1.txt','UTF-8',function(err,data){
    if(err){
        console.info(err);
    }else{
        console.info(data);
    }
});
console.info('end...');