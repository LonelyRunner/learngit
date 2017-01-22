var fs = require("fs");
var buf = new Buffer(1024);

fs.open("./sample.txt",'r+',function(err,fd){
    if(err){
        console.info("文件打开失败...");
    }
    console.info("文件打开成功...");

    /**
     * 文件截取：fs.ftruncate(fd,length,callback(err))
     */
    fs.ftruncate(fd,10,function(err){
        if(err){
            console.info("文件截取失败...");
        }

        console.info("文件截取成功...");
        /**
         * fs.read(fd,buf,offset,length,position,callback(err,bytes,buffer))
         */
        fs.read(fd,buf,0,buf.length,0,function(err,bytes){
            if(err){
                console.info("截取后的文件读取失败...");
            }

            console.info("截取后的文件读取成功...");
            if(bytes>0){
                console.info("读取了"+bytes+"个字节!");
            }
            console.info("截取后的文件数据:"+buf.slice(0,bytes).toString());
        });

        /**
         * fs.close(fd,callback)
         */
        fs.close(fd,function(err){
            if(err){
                console.info("文件关闭异常...");
            }
        });
    });
});