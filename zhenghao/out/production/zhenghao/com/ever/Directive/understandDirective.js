var myApp = angular.module("myApp",[]);

myApp.controller("mainController",["$scope",function($scope){

}]);

/**
 * 当scope为false时  继承但不隔离  即父类的改变会影响子类，子类的改变也会影响到父类
 * 当scope为true时   继承并隔离   即改变父类时 子类会变   but 改变子类时父类不会发生变化
 * */
myApp.directive("myDirective",function(){
    return{
        restrict:'A',
        scope:true,
        priority:100,
        template:'<div>内部：{{myProperty}}  <input type="text" ng-model="myProperty"></div>'
    }
});
