var fs = require("fs");

/**
 * fs.rmdir(dir,callback(err));
 */
fs.rmdir("./readyDel",function(err){
    if(err){
        throw err;
    }

    console.info("删除目录成功!");
});