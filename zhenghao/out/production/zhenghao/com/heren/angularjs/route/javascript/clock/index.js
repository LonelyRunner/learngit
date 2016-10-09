var myApp = angular.module("myApp",[]);
myApp.controller("myController",function($scope){
    console.log("who ...");
        $scope.$apply(function(){
            var date = new Date();
            $scope.goTime = date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒";
        });

    console.info("what ... ");

    $scope.student = {
        name:'zh',
        age:23
    };
});