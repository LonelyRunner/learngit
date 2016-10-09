angular.module('myApp',[])
.directive('test',function(){
        return{
            restrict:'AE',
            replace:true,
            template:'<div class="thank" id="thank">thank you</div>',
            /**
             * compile函数在link函数被执行之前用来做一些DOM改造
             * 它接受的参数有：tElement(指令所在的元素)，attrs(元素上赋予的参数的标准化列表)
             * compile函数不能访问scope，并且必须返回一个link函数。有了compile就不能用link。
             * */
            compile:function(tElem,attrs){
                console.info(tElem);
                console.info(attrs);
                return function(scope,elem,attrs){
                    elem.bind("dblclick",function(){
                        elem.css("background-color",'red');
                    });
                }
            }
        }
    });