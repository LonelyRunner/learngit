var fs = require('fs');

fs.open('context.txt','r',function(err,fd){
    if(err){
        console.info(err);
        return;
    }

    var buf = new Buffer(8);
    //fs.read(fd,buf,offset,length,position,[callBack(err,bytesRead,buffer)])
    /**
     * 从指定的文件描述符fd中读取数据并写入buf指向的缓冲区对象。
     * offset是buf的写入偏移量  length是要从文件中读取的字节数
     * position是文件读取的其实位置  如果为null 则会从单签文件指针的位置读取
     *
     * 回调函数传递bytesRead个buffer 分别表示读取的字节数和缓冲区对象
     */
    fs.read(fd,buf,0,8,null,function(err,bytesRead,buffer){
        if(err){
            console.info(err);
            return ;
        }

        console.info('bytesRead: '+bytesRead);
        console.info(buffer);
    });
});