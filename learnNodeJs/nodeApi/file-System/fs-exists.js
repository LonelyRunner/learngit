var fs = require('fs');

/**
 * 校验某个文件是否存在
 * fs.exists('fileName',callBack);
 */
fs.exists('sample.txt',function(exists){
    if(exists){
        fs.readFile('sample.txt','UTF-8',function(err,data){
            if(err){
                return ;
            }else{
                console.info(data);
            }
        });
        console.info('This file is exists in current folder!');
    }else{
        console.info('Sorry! The file that you are browser is not exists');
    }
});

console.info('This method is judge someone file 是否存在！');

/**
 * 同步方法: fs.existsSync(fileName)
 */