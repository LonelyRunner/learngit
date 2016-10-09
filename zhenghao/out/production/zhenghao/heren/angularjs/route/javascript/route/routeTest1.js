var routeApp = angular.module("routeApp",['ngRoute']);

routeApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
        .when('/route1',{
        templateUrl:'route1.html',
        controller:'routeOneController'
        })
        .when('/route2',{
            templateUrl:'route2.html',
            controller:'routeTwoController'
        })
        .otherwise({
            redirectTo:'/route1'
        })
}]);

/** when 中的参数 */
/** 第一个参数为路由路径
 *
 *  第二个参数为配置对象
 *          可以进行设置的属性包括：controller,templateUrl,template,resolve,redirectTo,reloadOnSearch*/

routeApp.controller("routeOneController",function($scope){

});
routeApp.controller("routeTwoController",function($scope){

});

routeApp.controller("routeController",["$scope","$routeParams","$location",function($scope,$routeParams,$location){
    $scope.a = "Hello,this is route example";
    console.info($routeParams);
    console.info("页面当前路径："+$location.path());
    console.info("获取编码后完整的URL："+$location.absUrl());
    console.info("获取Url中的hash片段："+$location.hash());
    console.info("获取Url中的主机："+$location.host());
    console.info("获取Url中的端口号："+$location.port());
    console.info("获取协议："+$location.protocol());
    console.info("获取Url中的查询串："+$location.search());
    console.info("获取Url中的url："+$location.url());
}]);

//JavaScript
console.log(window.location);

