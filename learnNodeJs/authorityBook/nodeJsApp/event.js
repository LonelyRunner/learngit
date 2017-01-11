//获取EventEmitter类
var EventEmitter = require('events').EventEmitter;
var event = new EventEmitter();

//on 接受事件名  并带有回调函数
event.on('someEvent',function(){
    console.info('我监听到了该事件');
});

setTimeout(function(){
    //emit将事件名发送
    event.emit('someEvent');
},1000);