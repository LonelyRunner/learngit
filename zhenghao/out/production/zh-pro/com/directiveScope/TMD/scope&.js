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
    ]
});

/** 作用域把父作用域的属性包装成一个函数 从而以函数的方式读取父作用域中的属性 */
myApp.directive("sonDirective",function(){
    return {
        restrict: 'ECAM',
        controller: function($scope){
            console.info("内部作用域-----指令");
            console.info($scope);
            $scope.books = $scope.a();
            console.info("内部作用域-----指令");
        },
        //当为对象的时候也会创建一个独立的作用域
        scope: {
            a: '&books'         //这里的books是页面<son-directive books="books"></son-directive> 的第一个books
                                //而这里的a相当于一个scope的方法
        },
        template: '<div><ul><li ng-repeat="book in books">{{book.name}}</li></ul></div>'
    }
});
