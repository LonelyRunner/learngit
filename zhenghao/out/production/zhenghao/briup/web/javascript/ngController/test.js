var myApp = angular.module("myApp",[]);
myApp.controller("someController",function($scope){
    $scope.student = {
        hi : "Hello world,Some"
    };
    $scope.st = "Hello world from some";
});

myApp.controller("childController",function($scope){
    //$scope.student = {
    //    hi : 'Hello world,Child!'
    //};
    //$scope.st = "Hello world from child";
});

myApp.controller("ngSwitchController",function($scope){
    $scope.name = "who";
});