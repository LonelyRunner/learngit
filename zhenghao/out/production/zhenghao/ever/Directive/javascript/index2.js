var myApp = angular.module('myApp',[]);
myApp.directive('expander',function(){
    return{
        restrict:'EA',
        replace:true,
        transclude:true,
        scope : {
            title : '=expanderTitle'
        },
        template:'<div>' +
                  '<div class="title" ng-click="toggle()">{{title}}</div>'+
                  '<div class="body" ng-show="showMe" ng-transclude></div>'+
                  '</div>',
        /** 这里的link对数据进行绑定，但只是对局部Template中的数据进行绑定*/
        link:function(scope,element,attrs){
            scope.showMe=false;
            scope.toggle = function(){
                scope.showMe = !scope.showMe;
            }
        }
    }
});
/* 下面的Controller相当于一个全局的控制器 */
myApp.controller('myController',['$scope',function($scope){
    $scope.title = '点击展开';
    $scope.text = '这里是内部的内容';
}]);