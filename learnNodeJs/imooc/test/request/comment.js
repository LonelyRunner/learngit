/** 运行此js可以在慕课网上追加一条评论  */

var http = require('http');
var querystring = require('querystring');

var postData = querystring.stringify({
    'content' : '而且非常幽默',
    'mid' : 8837
});

var options = {
    hostname : 'www.imooc.com',
    port:80,
    path:'/course/docomment',
    method:'POST',
    headers : {
        'Accept':'application/json, text/javascript, */*; q=0.01',
        'Accept-Encoding':'gzip, deflate',
        'Accept-Language':'zh-CN,zh;q=0.8',
        'Connection':'keep-alive',
        'Content-Length':postData.length,
        'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8',
        'Cookie':'imooc_uuid=c9614060-1399-46b5-a3ab-891b0603eac9; imooc_isnew_ct=1460966333; loginstate=1; apsid=gxY2U1YzlkYzU1MWJiODg0NGFlNjNlOGJlOTk0YTIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMjE2NzM2NAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4MjYyNzAzNjJAcXEuY29tAAAAAAAAAAAAAAAAAAAAAGEzODQ5ZjgyZWFkNzI0OWVkMDc3NDJiNWMwMDU5OTEynuwSWJ7sElg%3DMj; last_login_username=826270362%40qq.com; PHPSESSID=ftl7tmb8v48d9purj9ce31gfd2; jwplayer.qualityLabel=é«æ¸; IMCDNS=0; Hm_lvt_f0cfcccd7b1393990c78efdeebff3968=1478482810,1478602360,1478655454,1478740631; Hm_lpvt_f0cfcccd7b1393990c78efdeebff3968=1478760328; imooc_isnew=2; cvde=5823ca9599ddb-29',
        'Host':'www.imooc.com',
        'Origin':'http://www.imooc.com',
        'Referer':'http://www.imooc.com/video/8837',
        'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0',
        'X-Requested-With':'XMLHttpRequest'
    }
};

var req = http.request(options,function(res){
    console.info('Status:'+res.statusCode);
    console.info('Headers:'+JSON.stringify(res.headers));

    res.on('data',function(chunk){
        console.info(Buffer.isBuffer(chunk));
        console.info(typeof chunk);
    });

    res.on('end',function(){
        console.info('评论完毕!');
    });
});

req.on('error',function(e){
    console.info('Error:'+e);
});

req.write(postData);

req.end();