var express = require("express");

var app = express();
console.info(app);
app.use(express.static("public"));

app.get("/index.html",function(req,res){
    res.sendFile(__dirname+"/index.html");
});

app.get("/process_get",function(req,resp){
    var response = {
        firstName:req.query.firstName,
        lastName:req.query.lastName
    };

    console.info(response);

    resp.end(JSON.stringify(response));
});

var server = app.listen(2333,function(){
    var host = server.address().address;
    var port = server.address().port;

    console.log("应用访问的服务器地址是:http://%s:%s",host,port);
});