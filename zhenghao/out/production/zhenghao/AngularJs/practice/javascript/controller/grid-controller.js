GridController.$inject = ["$scope","$timeout"];
function GridController($scope,$timeout) {

    var amountCellTemplate = '<div class="ngCellText">{{row.getProperty(col.field)}}</div>';
    var amountEditableCellTemplate = "<input type='text' ng-model='row.entity.amount'>";

    $scope.selectedOrderDetails = [];
    $scope.columnDefs = [
        {
            field: 'drugName', displayName: '药品', width: "25%", cellClass: "text-center", cellTemplate: '' +
        '<div class="ngCellText">{{row.getProperty(col.field)}}</div>'
        },
        {
            field: 'amount',
            displayName: '数量',
            width: "25%",
            cellClass: "text-center",
            cellTemplate: amountCellTemplate,
            enableCellEdit: true,
            editableCellTemplate: amountEditableCellTemplate
        },
        {
            field: 'doctor', displayName: '医师', width: "25%", cellClass: "text-center", cellTemplate: '' +
        '<div class="ngCellText">{{row.getProperty(col.field)}}</div>'
        },
        {
            field: 'status', displayName: '状态', width: "25%", cellClass: "text-center", cellTemplate: '' +
        '<div class="ngCellText">{{row.getProperty(col.field)}}</div>'
        }
    ];
    var rowTemplate = "<div ng-style=\"{ \'cursor\': row.cursor}\" ng-repeat=\"col in renderedColumns\" ng-click=\"selectOrder(row.entity)\" ng-dblclick=\"updateOrder()\"\n    ng-class=\"col.colIndex()\" class=\"ngCell\">\n    <div ng-cell></div>\n</div>";
    $scope.ordersGrid = {
        data: 'orderDetailList',
        columnDefs: 'columnDefs',
        rowTemplate: rowTemplate,
        enableColumnResize: false,
        multiSelect: false,
        enableSorting: true,
        selectedItems: $scope.selectedOrderDetails,
        beforeSelectionChange: function (rowItem, event) {
            if (event.type === "keydown" && event.keyCode === 13) {
                return false;
            }
            return true;
        },
        afterSelectionChange:function (rowItem,event){
            $scope.selectOrder(rowItem.entity);
        }

    };


    $scope.gridScroll=function (){
        $timeout(function () {
            if ($scope.orderDetailList.length > 0 && $scope.selectedOrderDetails.length > 0) {
                $scope.selectedOrderDetail = angular.copy($scope.selectedOrderDetails[0]);
                var rowNum = $scope.getSelectedRowNum($scope.selectedOrderDetail.orderId);
                $scope.ordersGrid.selectItem(rowNum, true);
                var grid = $scope.ordersGrid.ngGrid;
                grid.$viewport.scrollTop(grid.rowMap[rowNum] * grid.config.rowHeight);
            }
        }, 500);
    };


    $scope.getSelectedRowNum = function () {
        var index = -1;
        for (var i = 0; i < $scope.orderDetailList.length; i++) {
            if ($scope.orderDetailList[i].orderId === $scope.selectedOrderDetail.orderId) {
                index = i;
                break;
            }
        }
        return index;
    };

    $scope.selectOrder = function (entity) {
        $scope.selectedOrderDetails.splice(0);
        $scope.selectedOrderDetails.push(entity);
        $scope.selectedOrderDetail = angular.copy($scope.selectedOrderDetails[0]);
        $scope.gridScroll();
    };

    $scope.updateOrder = function () {

    };
}


