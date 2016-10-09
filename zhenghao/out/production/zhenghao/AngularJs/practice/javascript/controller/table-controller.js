TableController.$inject = ["$scope"];
function TableController($scope) {
    $scope.selectedOrderDetail = null;
    $scope.selectOrderDetail = function (index) {
        $scope.selectedOrderDetail = $scope.orderDetailList[index];
    };
    $scope.isSelectedOrderDetail=function(orderDetail){
        return angular.equals($scope.selectedOrderDetail, orderDetail);
    };
}


