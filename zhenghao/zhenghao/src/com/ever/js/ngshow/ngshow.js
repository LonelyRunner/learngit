var myApp = angular.module("myApp",[]);
myApp.controller("myController",function($scope){
    $scope.up = false;
    $scope.down = false;
    $scope.default = false;
    $scope.a =0;
    $scope.b = 1;
    $scope.select = function(){
        if($scope.a + $scope.b >2){
            $scope.up = true;
            $scope.down = false;
            $scope.default = false;
        }else if($scope.a+$scope.b===2){
            $scope.default=true;
            $scope.up = false;
            $scope.down = false;
        }else if($scope.a+$scope.b <2){
            $scope.down = true;
            $scope.up = false;
            $scope.default = false;
        }
    }
})