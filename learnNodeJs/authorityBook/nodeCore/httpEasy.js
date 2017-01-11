//http创建一个简单的服务的两种方式
//a
var http = require('http');

/**
    http.createServer(function(req,res){
        res.writeHead(200,{'Content-Type':'text/html'});
        res.write('<h1>Hello world!隐式调用http.Server</h1>');
        res.end('<br>This is end !');
    }).listen(3000);

    console.info('This server is listening port of 3000!');
*/

//b
var server = http.Server();

server.on('request',function(req,res){
    res.writeHead(200,{'Content-Type':'text/html'});
    res.write('<h1>Hello world!显式调用http.Server</h1>');
    res.end('<br>This is end !');
});

server.listen(3000);

console.info('This server is listening port 3000!');