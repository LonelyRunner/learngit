var fs = require("fs");

fs.readFile("./sample.txt",'UTF-8',function(err,data){
    if(err){
        console.info(err);
    }else{
        console.info(data);
    }
});

console.info("Reading a file is successful");

//同步方法:fs.readFileSync(file[,options]);