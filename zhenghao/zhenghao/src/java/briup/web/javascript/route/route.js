var myApp = angular.module("myApp",['ngRoute']);
myApp.controller("textController",function($scope){
    $scope.someText = "测试显示内容";
});

function emailRouteConfig($routeProvider){
    $routeProvider
        .when('/',{
        controller:ListController,
        templateUrl:'list.html'
        })
        /** 在id前面加一个冒号  从而指定一个参数化的URL*/
        .when('/view/:id',{
            controller:DetailController,
            templateUrl:'detail.html'
        })
        .otherwise({
            redirect:'/'
        });
}


/** 配置路由 */
myApp.config(emailRouteConfig);
var messages = [
    {
        id:0,
        sender:'123456@qq.com',
        subject:'你好，这是一封邮件',
        date:"2015-01-01"
    },
    {
        id:1,
        sender:'123456@qq.com',
        subject:'你好，这是一封邮件',
        date:"2015-01-02"
    },
    {
        id:2,
        sender:'123456@qq.com',
        subject:'你好，这是一封邮件',
        date:"2015-01-03"
    }
];

function ListController($scope){
    $scope.messages = messages;
}

function DetailController($scope,$routeParams){
    $scope.message = messages[$routeParams.id];
}