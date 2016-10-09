var myApp = angular.module("myApp",[]);
myApp.controller("myController",function($scope){
    $scope.students = [
        {
            name:'1',
            age:2
        },
        {
            name:'2',
            age:3
        },
        {
            name:'3',
            age:4
        }
    ];

    angular.forEach($scope.students,function(_item){
        console.info(_item.name);
    });
});
