var util = require('util');

function Base(){
    this.name = 'Base';
    this.base = 1991;
    this.sayHello = function(){
        console.info('Hello:'+this.name);
    }
}

Base.prototype.showName = function(){
    console.info(this.name);
};

function Sub(){
    this.name = 'Sub';
}

//Sub 继承 Base  仅仅继承了Base在原型中定义的函数，构造函数内部创造的属性和函数都没能继承。
util.inherits(Sub,Base);

var objBase = new Base();

console.info(objBase.name);
objBase.sayHello();
objBase.showName();


var objSub = new Sub();
console.info(objSub.name);
objSub.showName();
//objSub.sayHello();
console.info(objSub.base);