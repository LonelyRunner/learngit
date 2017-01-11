var util = require('util');

//util.inspect是将一个对象转换为字符串
/**
 * 该方法有四个参数
 * 1.需要转换的对象
 * 2.showHidden : true时显示更多的隐藏信息
 * 3.depth : 表示最大的递归层数 默认为2  null时全部递归
 * 4.color : boolean值  在终端显示更漂亮时使用
 * */

function Person(){
    this.name = "张三";
    this.hobby = ['play basketball','play football','play volleyball'];
    this.getName = function(){
        return this.name;
    };

    this.pet = [
        {petName:'dog',petEyes:2},
        {petName:'cat',petEyes:2}
    ];
}

var personObj = new Person();

console.info(util.inspect(personObj));
console.info(util.inspect(personObj,true));