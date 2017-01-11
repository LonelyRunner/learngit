var event = require('events');

var e = new event.EventEmitter();

e.on('someEvent',function(arg1,arg2){
    console.info("This is Listener1 and "+arg1+" is "+arg2);
});

e.on('someEvent',function(arg1,arg2){
    console.info('This is Listener2 and '+arg1+' is '+arg2);
});

e.emit('someEvent','密码','123321');