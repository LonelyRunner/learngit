var myApp = angular.module("myApp",['ngRoute']);
myApp.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl:'home.html',
            controller:'mainController'
        })
        .when('/about',{
            templateUrl:'about.html',
            controller:'aboutController'
        })
        .when('/contact',{
            templateUrl:'contact.html',
            controller:'contactController'
        })
});

myApp.controller('mainController',function($scope){
    $scope.message = "Look! I am an about page";
});

myApp.controller('aboutController',function($scope){
    $scope.message = "I'm a page about ABOUT";
});

myApp.controller('contactController',function($scope){
    $scope.message = "I'm a page about CONTACT";
});