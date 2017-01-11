var fs = require('fs');

//todo 待研究
fs.createReadStream('sample.txt',{start:90,end:99});

fs.readFile('sample.txt','utf-8',function(err,data){
    if(err){
        console.info(err);
    }else{
        console.log(data);
    }
});