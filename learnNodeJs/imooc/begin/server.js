var http = require('http');
http.createServer(function(req,resp){
    req.writeHead(200,{'Content-Type':'text/plain'});
    req.end('Hello world!');
}).listen(1337,'127.0.0.1');

console.info('server run success!');