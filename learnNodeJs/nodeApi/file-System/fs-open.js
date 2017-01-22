var fs = require("fs");

console.info("准备打开文件");
fs.open("sample.txt",'r+',function(err){
    if(err) throw err;
    else console.info("文件打开成功!");
});