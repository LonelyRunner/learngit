var fs = require("fs");

fs.appendFile("./NBA/head.txt","Miami Heat",function(err){
    if(err){
        console.info("追加文件失败...");
    }
    console.info("追加文件成功...");
});

/**
 * fs.readdir(dir,callback(err,files)) : files为该dir下面的所有的文件名称 是一个数组
 */
fs.readdir("./NBA",function(err,files){
    if(err){
        console.info(err);
    }

    console.info(files);
});