var fs = require('fs');

//查看文件状态 stats 是 fs.Stats 对象
fs.stat("./message.txt",function(err,stats){
    if(err) throw err;
    for(var i in stats){
        console.info(i+":"+stats[i]);
    }
});