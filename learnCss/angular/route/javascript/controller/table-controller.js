TableController.$inject = ["$scope"];
function TableController($scope) {
    //表格table各列自适应宽度List
    $scope.orderWidth=[];
    $scope.selectedOrderDetail = null;
    $scope.selectOrderDetail = function (index) {
        $scope.selectedOrderDetail = $scope.orderDetailList[index];
    };
    $scope.isSelectedOrderDetail=function(orderDetail){
        return angular.equals($scope.selectedOrderDetail, orderDetail);
    };
}


