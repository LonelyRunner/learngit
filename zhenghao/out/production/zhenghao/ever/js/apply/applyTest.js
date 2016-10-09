var myApp = angular.module("myApp",[]).controller("MessageController",function($scope){
    $scope.message = 'Feched after 3 seconds';
    console.log($scope);
    $scope.getMessage = function(){
        setTimeout(function(){
            console.log("message"+$scope.message);

            console.log($scope);
        },2000)
    }
    $scope.getMessage();
})