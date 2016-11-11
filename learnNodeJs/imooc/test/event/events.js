var EventEmitter = require('events').EventEmitter;
var life = new EventEmitter();

//官方规定对一个事件的监听不超过10个  但是可以通过setMaxListeners来改变最大监听数
life.setMaxListeners(11);

function XZSelect(who){
    console.info('小张选'+who+'为总统!');

}

life.on('selectTrump',XZSelect);

life.on('selectTrump',function(who){
    console.info('小李选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小王选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小吴选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小章选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小赵选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小薛选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小晓选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小杨选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小秦选'+who+'为总统!');
});

life.on('selectTrump',function(who){
    console.info('小郑选'+who+'为总统!');
});

life.on('selectHillary',function(who){
    console.info('小牛选'+who+'为总统');
});

life.on('selectHillary',function(who){
    console.info('小周选'+who+'为总统');
});

/** 移除一个监听事件 比如移除小张 第一个  只能写成类似形式
 *  第一个参数为事件名  第二个参数为函数名 注:此函数不能为匿名函数
 * */
life.removeListener('selectTrump',XZSelect);

/** 移除某事件下面的所有监听 */
life.removeAllListeners('selectTrump');

life.emit('selectTrump','Trump');
life.emit('selectHillary','Hillary');

/** 输出某个事件的监听个数 */
console.info(life.listeners('selectTrump').length);
console.info(EventEmitter.listenerCount(life,'selectTrump'));
console.info(life.listeners('selectHillary').length);


//注释:emit和on类似于angularJs中的$emit和$on      一个向上发送请求  一个接受请求