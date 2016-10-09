/**
 * makeArray函数可以说不是一个松散的全局函数，而是全局对象的一个方法。
 * @param arg1
 * @param arg2
 * @returns {*[]}
 */
function makeArray(arg1,arg2){
    console.info(this,arg1,arg2);
    return [this,arg1,arg2];
}

makeArray("one","two");


//方法调用模式
//在一个使用方法调用语法中，想obj.myfunction()或者obj.['myFunction']()，这时this的值为obj
/**
 * 看到这里的不同了吧,this的值变成了对象本身.你可能会疑问原始的函数定义并没有改变,
 * 为何它不是window了呢.好吧,这就是函数在JavaScript中传递的方式,函数在JavaScript里
 * 是一个标准的数据类型,确切的说是一个对象.你可以传递它们或者复制他们.就好像整个函
 * 数连带参数列表和函数体都被复制,且被分配给了 arrayMaker里的属性make,那就好像这样
 * 定义一个 arrayMaker:
 * var arrayMaker = {
 *      someProperty: 'some value here',
 *      make: function (arg1, arg2) {
 *          return [ this, arg1, arg2 ];
 *          }
 *    };
 */
var arrayMaker = {
    someProperty:'some value here',
    make:makeArray
}
arrayMaker.make('one','two');
arrayMaker['make']('three','four');


//构造器调用模式
//当你将函数用作初始化函数的时候,像MyFunction(),Javascript的运行时将把this的值指定为新建的对象.

//声明一个构造器
    function ArrayMaker1(arg1,arg2){
        this.someProperty = 'whatever';
        this.theArray = [this,arg1,arg2];
    }
    ArrayMaker1.prototype = {
        someMethod:function(){
            alert('someMethod called');
        },
        getArray:function(){
            return this.theArray;
            console.log(this.theArray);
        }
    }

var am = new ArrayMaker1('one','two');
var other = new ArrayMaker1('first','second');
am.getArray();


//apply 和 call方法
/**
 * 不同的是后面的参数的不同,Function.apply()是使用一个数组来传递给函数的,
 * 而Function.call()是将这些参数独立传递的,
 * 在实践中你会发现apply()在大多数情况下更方便.
 */

var gasGuzzler = {year:2008,model:'Dodge Bailout'};
makeArray.apply(gasGuzzler,['one','two']);
makeArray.call(gasGuzzler,'one','two');
