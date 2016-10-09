angular.module("myApp",[])
.controller("myController",function($scope){

    })
.directive("helloWorld",function(){
        return{
            restrict:'AE',
            replace:true,
            template:'<p style="background-color: {{color}}">Hello world!</p>',
            /**
             * link函数主要用来为DOM元素添加事件监听、监视模型属性变化，以及更新DOM
             * */
            link:function(scope,element,attr){
                element.bind("click",function(){
                    element.css("background-color",'white');
                });
                scope.$apply(function(){
                    scope.color = 'white';
                });
                element.bind('mouseover', function() {
                    element.css('cursor', 'pointer');
                });
            }
        }
    });
