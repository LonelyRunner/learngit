var express = require("express");
var app = express();

console.info(app);

app.get("/",function(req,resp){
    resp.send("hello world");
});

var server = app.listen(2231,function(){
    var host = server.address().address;
    var port = server.address().port;

    console.info("-----------------------------------");
    console.info(server.address);
    console.info("-----------------------------------");
    console.info("应用实例访问的url是:http://%s:%s",host,port);
});


/**
 * npm install express :安装express 简洁而灵活的node.js web框架
 * npm install body-parser :node.js中间件 用于处理JSON，Raw，Text和URL编码
 * npm install cookie-parser :这就是一个解析Cookie的工具。通过req.cookies可以取到传过来的cookie，并把它们转成对象
 * npm install multer: node.js 中间件，用于处理 enctype="multipart/form-data"（设置表单的MIME编码）的表单数据
 * */