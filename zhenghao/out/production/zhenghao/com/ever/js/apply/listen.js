var myApp = angular.module("myApp",[]);
myApp.controller("myController",function($scope){
    $scope.name="Jordan";
    $scope.strVar = "This will change after 2s";
    $scope.$watch("name",function(newValue,oldValue){
        console.info(newValue+"----------------"+oldValue);
        $scope.count = 0;
        ++$scope.count;
    });
    setTimeout(function(){
        $scope.$apply(function(){
            $scope.strVar = "This is Me,through 2 seconds";
        });
    },2000);

    $scope.stuArray = [
        {
            "name":"郑豪",
            "age":23,
            "gender":"boy"
        },
        {
            "name":"her",
            "age":24,
            "gender":"girl"
        },
        {
            "name":"ourSon",
            "age":0,
            "gender":"son"
        }
    ];
    $scope.deleteStu = function(index){
        console.info(index);
        for(var i=0;i<$scope.stuArray.length;i++){
            if(i===index){
                $scope.stuArray.splice(index,1);
            }
        }
    }
});
