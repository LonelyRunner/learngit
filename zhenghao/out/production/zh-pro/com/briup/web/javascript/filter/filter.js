var myApp = angular.module("myApp",[]);
myApp.controller("myController",function($scope,currencyFilter){
    $scope.americaMoney = currencyFilter(12234);
    $scope.num1 = 123435;
    $scope.num2 = 234567;
});

myApp.controller("brotherController",function($scope,$filter){
    $scope.num = $filter('currency')(12345);
    $scope.date = $filter('date')(new Date());
});

myApp.filter("myFilter",function(){
    return function(i){
        if(i%2 === 0){
            return i;
        }else{
            return 0;
        }
    }
});
myApp.filter("reverse",function(){
   return function(input,uppercase){
       var output = "";
       for(var i=0;i<input.length;i++){
           output = input[i] + output;
       }
       if(uppercase){
           output = output.toUpperCase();
       }
       return output;
   }
});
myApp.controller("customerController",function($scope){
    $scope.num = 5;
    $scope.number1 = 123444422323;
    $scope.number2 = 12342132;
});
