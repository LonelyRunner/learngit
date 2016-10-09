var myApp = angular.module("myApp",[]);
myApp.controller("ngChangeController",function($scope){
    $scope.equation = {};
    $scope.change = function() {
        $scope.equation.output
            = parseInt($scope.equation.x) + 2;
    };
});