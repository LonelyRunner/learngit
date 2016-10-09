var myApp = angular.module("myApp",[]);
myApp.controller("testArrowController",function($scope){
    $scope.a = 5;
    $scope.b = 2;
    console.log("$scope.a:"+$scope.a);
    if($scope.a+$scope.b>3){
        $scope.isActive = false;
    }else{
        $scope.isActive = true;
    }
    $scope.$watch("",function(oldValue,newValue){

    });
    $scope.data = {
        one:"one",
        two:"two",
        three:"three"
    }
})