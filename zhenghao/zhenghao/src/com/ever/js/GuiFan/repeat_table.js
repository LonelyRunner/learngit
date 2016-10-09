var tableModelApp = angular.module('tableModelApp',[]);
tableModelApp.controller('tableModelController',['$scope',function($scope){
    $scope.phones = [
        {
           id:0001,
            name:'oppo',
            price:3200
        },
        {
            id:0002,
            name:'apple',
            price:6200
        },
        {
            id:0003,
            name:'sansum',
            price:3800
        }
    ];
    $scope.soccer='C罗';
}]);