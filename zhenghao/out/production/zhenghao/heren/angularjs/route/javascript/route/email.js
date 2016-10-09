var myApp = angular.module("myApp",["ngRoute"]);

myApp.config(["$routeProvider",function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl:'email.html',
            controller:'listController'
        })
        .when('/detail/:id',{
            templateUrl:'detailEmail.html',
            controller:'detailController'
        })
        .otherwise({
            redirectTo:'/'
        });
}]);

myApp.controller("detailController",function($scope,$routeParams){
    console.info($routeParams);
    $scope.detailEmails = [
        {
            id:0,
            sender:'Marry',
            information:'Hello! My name is Marry! I like you some days',
            receiver:'Jordan'
        },
        {
            id:1,
            sender:'表弟',
            information:'Hi! I want to travel round the world',
            receiver:'表姐'
        },
        {
            id:2,
            sender:'丽丽',
            information:'Good Morning! Today is a good day',
            receiver:'莉莉'
        },
        {
            id:3,
            sender:'三炮',
            information:'Have a good fun! The food is very delicious',
            receiver:'小三'
        },
        {
            id:4,
            sender:'郑豪',
            information:'This is 郑豪, I don\'t forget you',
            receiver:'lover'
        }
    ];
    $scope.detailEmail = $scope.detailEmails[$routeParams.id];
});

myApp.controller("listController",function($scope){
    $scope.emails = [
        {
            id:0,
            sender:'Marry',
            information:'Hello! My name is ...',
            receiver:'Jordan'
        },
        {
            id:1,
            sender:'表弟',
            information:'Hi! I want to ...',
            receiver:'表姐'
        },
        {
            id:2,
            sender:'丽丽',
            information:'Good Morning! Today is ...',
            receiver:'莉莉'
        },
        {
            id:3,
            sender:'三炮',
            information:'Have a good fun! ...',
            receiver:'小三'
        },
        {
            id:4,
            sender:'郑豪',
            information:'This is 郑豪, ...',
            receiver:'lover'
        }

    ];
});