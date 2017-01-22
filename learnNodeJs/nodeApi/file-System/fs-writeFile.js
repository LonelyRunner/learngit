var fs = require("fs");
var util = require("util");
var data = util.inspect({
    name:'郑豪',
    age:23,
    gender:'male',
    graduate: 'Technology University of TaiYuan',
    method : '软件工程'
});

/**
 * fs.writeFile(path,data[,options],callback(err))
 * 如果path不存在  则创建新的文件
 * 如果存在  则data将覆盖原先文件中存在的数据
 */
fs.writeFile("./NBA/cavaliers.txt",data,"utf-8",function(err){
    if(err){
        throw err;
    }else{
        fs.readFile("./NBA/cavaliers.txt",function(err1,data1){
            if(err1){
                console.info("reading file is a fail");
            }else{
                console.info(data.toString());
            }
        });
    }
});

console.info("reading file start!");