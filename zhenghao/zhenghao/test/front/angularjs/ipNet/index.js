var ipApp = angular.module('ipApp',[]);

ipApp.controller('CalculatorRelativeCtrl',["$scope",function($scope){

    $scope.ipData = getItem();
    $scope.subNetMaskData = getItem();
    $scope.netAddress = getItem();
    $scope.broadcastAddress = getItem();

    $scope.calculator = function(){
        var ipStr = "";
        var subNetMaskStr = "";
        for(var i in $scope.ipData){
            ipStr += convert10to2($scope.ipData[i])+":";
        }

        for(var i in $scope.subNetMaskData){
            subNetMaskStr += convert10to2($scope.subNetMaskData[i])+":";
        }

        console.info(ipStr);
        console.info(subNetMaskStr);
    };

    function getItem(){
        var item = {
            data1 : "",
            data2 : "",
            data3 : "",
            data4 : ""
        };
        return item;
    }

    function convert10to2(data){
        var str = "";
        var result = [];
        var resultSet = [];
        //商s 余数y
        if (data == 0) {
            result = ['0','0','0','0','0','0','0','0'];
        } else {
            do {
                var y = data % 2;
                var s = (data - y) / 2;
                data = s;
                result.push(y + "");
            } while (s != 0);
        }
        if (result.length < 8) {
            var newArray = [];
            for (var i = 0; i < 8 - result.length; i++) {
                newArray.push("0");
            }
            resultSet = result.concat(newArray);
        }else{
            resultSet = result;
        }

        for(var i=resultSet.length-1;i>=0;i--){
            str += resultSet[i];
        }
        return str;
    }
    console.info(convert10to2(0));

    function validateIndexOf(a,arr){
            if(arr.indexOf(a)>0){
                console.info("include");
            }else{
                console.info("no include");
            }
    }

    validateIndexOf("a",['b','a','c']);
    
    var a = [1,2,3,4,5];
    a.push();

}]);