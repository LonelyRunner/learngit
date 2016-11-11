/** 评论自己的qq */
var http = require('http');
var querystring = require('querystring');

var postData = querystring.stringify({
    'qzreferrer':'http://user.qzone.qq.com/826270362/infocenter?ptsig=dxjTzv*twkBAQzQbclVyoOtg*EtOC*QdCGlp0J1XeD8_',
    'topicId':'826270362_9ae23f31b4461f5896070600__1',
    'feedsType':'100',
    'inCharset':'utf-8',
    'outCharset':'utf-8',
    'plat':'qzone',
    'source':'ic',
    'hostUin':'826270362',
    'isSignIn':'',
    'platformid':52,
    'uin':'826270362',
    'format':'fs',
    'ref':'feeds',
    'content':'这是我没有在qq空间中自己评论自己的说说',
    'richval':'',
    'richtype':'',
    'private':0,
    'paramstr':1
});

var options = {
    hostname : 'h5.qzone.qq.com',
    port:80,
    path:'/proxy/domain/taotao.qzone.qq.com/cgi-bin/emotion_cgi_re_feeds?g_tk=1143250648',
    method:'POST',
    headers :{
        'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
        'Accept-Encoding':'gzip, deflate',
        'Accept-Language':'zh-CN,zh;q=0.8',
        'Cache-Control':'max-age=0',
        'Connection':'keep-alive',
        'Content-Length':postData.length,
        'Content-Type':'application/x-www-form-urlencoded',
        'Cookie':'v6uin; v6uin; cuid=283932592; _gscu_661903259=59219242wrqtyb55; pac_uid=1_826270362; eas_sid=Z1H466O6A9R3n6M2k3u4l1E6Y1; tvfe_boss_uuid=c735651ed9e94c7a; __Q_w_s_hat_seed=1; luin=o0826270362; lskey=000100008658c09ab268be02f40d97d0f514279574cd9606adc3fe88f8cc7fc2069ffd43746de31dfe6f29cc; mobileUV=1_15800948ce0_47550; ptui_loginuin=826270362; __Q_w_s__appDataSeed=1; RK=OVs6KDbiGK; uid=32323871; pgv_pvi=8887054336; pgv_si=s8192838656; o_cookie=826270362; pgv_info=ssid=s9000036920; pgv_pvid=2693341286; pt2gguin=o0826270362; uin=o0826270362; skey=@VCOEg0T6E; ptisp=ctc; qzone_check=826270362_1478762189; ptcz=62ea2652a189fb1c9da94d01cef31f5a664d8acb4616d8c79e1db570978b92d5; blabla=dynamic; Loading=Yes; qzspeedup=sdch; p_skey=zO3ljIZwW0Q9TrCCFrZkJL2mx0J66pismJWjhZzMofY_; p_uin=o0826270362; pt4_token=Q-dcZurPBz8ERPvCxQMBLTaiar3-Fpj6ZCvnHrIdISU_; QZ_FE_WEBP_SUPPORT=1; cpu_performance_v8=10',
        'Host':'h5.qzone.qq.com',
        'Origin':'http://user.qzone.qq.com',
        'Referer':'http://user.qzone.qq.com/826270362/infocenter?ptsig=dxjTzv*twkBAQzQbclVyoOtg*EtOC*QdCGlp0J1XeD8_',
        'Upgrade-Insecure-Requests':1,
        'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0'
    }
};
var req = http.request(options,function(res){
    console.info('status:'+res.statusCode);
    console.info('header'+JSON.stringify(res.headers));

    res.on('data',function(chunk){
        console.info(Buffer.isBuffer(chunk));
        console.info(typeof chunk);
    });

    res.on('end',function(){
        console.info('评论自己的说说成功！');
    });
});

req.on('error',function(e){
    console.info('Error:'+e);
});

req.write(postData);

req.end();