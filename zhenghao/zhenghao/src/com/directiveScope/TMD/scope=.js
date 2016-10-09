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
            $scope.a.push({name:'nodejs',classTime:'12'});
            console.info("内部作用域-----指令");
        },
        //        双向绑定：通过=可以将本地作用域上的属性同父级作用域上的属性进行双向的数据绑定。
        //就像普通的数据绑定一样，本地属性会反映出父数据模型中所发生的改变
        scope: {
            a: '=equalScope'   //双向数据绑定  对应父作用域中的表达式
        },
        template: '<div><ul><li ng-repeat="book in a">{{book.name}}</li></ul></div>'
    }
});

