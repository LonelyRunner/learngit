var myApp = angular.module('myApp',[]);

myApp.controller('myController',['$scope',function($scope){
    $scope.imgs = [
        {
            show:false
        },
        {
            show:false
        },
        {
            show:false
        }
    ];
    $scope.a = 1;
    $scope.showNext = function(){
        setTimeout(function(){
            if($scope.a<$scope.imgs.length+1){
                console.log($scope.a);
                $scope.imgs[$scope.a-1].show = true;
                $scope.a = $scope.a+1;
            }
        },2000);
    }
}]);