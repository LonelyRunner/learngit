var myApp = angular.module("myApp",[]);
myApp.directive('hello',function(){
    return{
        restrict:'E',
        //template:'<div>Hello world,<span ng-transclude></span></div>',
        templateUrl:'myDream.html',
        replace:true,
        transclude:true
    }
});
myApp.directive('hi',function(){
    return{
        restrict:'E',
        template:'<span> in here!</span>',
        replace:true
    }
});
myApp.controller('myController',['$scope',function($scope){
    $scope.things = ['you\'re','he\'s','she\'s','I\'m'];
}]);

