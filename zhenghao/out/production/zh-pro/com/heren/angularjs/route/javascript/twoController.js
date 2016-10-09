var TwoControllerApp = angular.module("TwoControllerApp",[]);

TwoControllerApp.factory("twoService",function(){
    return [1,2,3,4];
});
TwoControllerApp.controller("AController",function($scope,twoService){
    console.info(twoService);
    $scope.a = twoService;

    $scope.addNewData = function(){
        console.info("--------");
        twoService.push(6);
        console.info($scope.a);
    }
});

TwoControllerApp.controller("BController",function($scope,twoService){
    console.info(twoService);
    $scope.b = twoService;
    console.info($scope.b);
});