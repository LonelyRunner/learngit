var http = require('http');
var util = require('util');
var url = require('url');

http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type':'text/html'});
    res.write(util.inspect(req));
    res.write("-----------------------------------");
    res.end(util.inspect(url.parse(req.url,true)));
}).listen(3000);

console.info("获取get请求...");

//请求 http://localhost:3000/?username=zhenghao&password=131425
//Url { protocol: null, slashes: null, auth: null, host: null, port: null, hostname: null, hash: null,
//      search: '?username=zhenghao&password=131425',
//      query: { username: 'zhenghao', password: '131425' },
//      pathname: '/', path: '/?username=zhenghao&password=131425',
//      href: '/?username=zhenghao&password=131425'
//    }