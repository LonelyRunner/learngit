var myApp = angular.module("myApp",[]);
/** 外部作用域 */
myApp.controller("fatherController",function($scope){
    console.info("外部作用域-----父controller");
    console.info($scope);
    console.info("外部作用域-----父controller");
    $scope.books = [
        {
            name: 'php',
            classTime: 48
        },
        {
            name: 'java',
            classTime: 24
        },
        {
            name: 'jpa',
            classTime: 36
        }
    ];
    $scope.title = "this is a sb title";
});

/** 本地作用域属性：使用@符号将本地作用域同DOM属性的值进行绑定。指令内部作用域可以使用外部作用域的普通类型的数据变量。不能绑定对象 */
myApp.directive("sonDirective",function(){
    return {
        restrict: 'ECAM',
        controller: function($scope){
            console.info($scope.a);
        },
        scope: {
            //使用简单的数据类型
            a: '@commonScope'
        },
        template: '<div><span>{{a}}</span></div>'
    }
});

