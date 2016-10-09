var myApp = angular.module('myApp',[]);
myApp.controller('myController',['$scope',function($scope){
    $scope.i = 1;
    $scope.showNext = function(){
        if($scope.i<3) {
            $scope.i = $scope.i + 1;
        }
    }
    $scope.showBefore = function(){
        if($scope.i>1){
            $scope.i = $scope.i-1;
        }
    }
}]);