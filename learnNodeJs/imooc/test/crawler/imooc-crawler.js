var http = require('http');
var url = 'http://www.imooc.com/learn/348';

http.get(url,function(response){
    var html = "";

    response.on('data',function(data){
        html += data;
    });

    response.on('end',function(){
        console.info(html);
    });
}).on('error',function(){
    console.info("获取课程网站源代码失败");
});