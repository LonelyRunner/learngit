var http = require('http');
var querystring = require('querystring');
var util = require('util');

//获取post请求
http.createServer(function(req,res){
    var post = '';

    req.on('data',function(chunk){
        post += chunk;
    });

    req.on('end',function(){
        post = querystring.parse(post);
        res.end(util.inspect(post));
    });
});