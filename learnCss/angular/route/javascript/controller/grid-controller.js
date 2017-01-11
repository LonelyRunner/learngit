GridController.$inject = ["$scope","$timeout"];
function GridController($scope) {

    var amountEditableCellTemplate = '<div ng-if="!isSelectedOrderDetail(row.entity)" >\n    <span>{{COL_FIELD}}</span>\n</div>\n\n<div  ng-if="isSelectedOrderDetail(row.entity)">\n    <input type=\'text\' ng-model=\'row.entity.amount\'>\n</div>';

    $scope.selectedOrderDetails = [];
    $scope.selectedOrderDetail=null;

    $scope.columnDefs = [
        {
            field: 'drugName', displayName: '药品', width: "25%",enableCellEdit: false, cellClass: "text-center", cellTemplate: '' +
        '<div class="ngCellText">{{row.getProperty(col.field)}}</div>'
        },
        {
            field: 'amount',
            displayName: '数量',
            width: "25%",
            cellClass: "text-center",
            enableCellEdit: true,
            editableCellTemplate: amountEditableCellTemplate
        },
        {
            field: 'doctor', displayName: '医师', width: "25%",enableCellEdit: false, cellClass: "text-center", cellTemplate: '' +
        '<div class="ngCellText">{{row.getProperty(col.field)}}</div>'
        },
        {
            field: 'status', displayName: '状态', width: "25%",enableCellEdit: false, cellClass: "text-center", cellTemplate: '' +
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
        enableCellEditOnFocus: true,//1、为了让“行编辑”生效，首先允许 “单元格编辑”(为了使ngGrid使用 "cellEditTemplate.html"模版)
        enableRowEditOnSelected: false,//2、行编辑模式：允许 “行编辑”
        selectedItems: $scope.selectedOrderDetails,
        beforeSelectionChange: function (rowItem, event) {
            if (event.type === "keydown" && event.keyCode === 13) {
                return false;
            }
            return true;
        },
        afterSelectionChange:function (rowItem,event){
            $scope.selectedOrderDetails.splice(0);
            $scope.selectedOrderDetails.push(rowItem.entity);
            $scope.selectedOrderDetail=$scope.selectedOrderDetails[0];
        }
    };


    $scope.isSelectedOrderDetail=function(entity){
        return angular.equals(entity,$scope.selectedOrderDetail);
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


    $scope.updateOrder = function () {

    };

    //$scope.ordersGrid.selectItem(rowNum, true); 选中某一行
    //$scope.ordersGrid.ngGrid.$viewport.scrollTop(grid.rowMap[rowNum] * grid.config.rowHeight); 设置滚动条
}


