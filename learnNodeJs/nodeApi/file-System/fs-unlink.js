var fs = require('fs');

//只会删除Cavaliers文件  不会删除文件夹
fs.unlink('./NBA/Cavaliers',function(err){
    if(err){
        console.info(err);
    }else{
        console.info('delete or unlink Success');
    }
});

console.info("骑士-爵士  fuck 裁判！");

//同步写法：fs.unlinkSync(path){}