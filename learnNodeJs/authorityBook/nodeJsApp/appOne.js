//node.js实现最简单的HTTP服务器
var http = require('http');
http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'text/html'});
	res.write('<h1>Hello World!</h1>');
	res.end('<p>Node.js====konwledge===I am a boy!</p>');
}).listen(3000);
console.info('HTTP Server is listening at port 3000.');