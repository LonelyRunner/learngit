var myApp = angular.module("myApp",['ngGrid']);

myApp.controller("myController",["$scope",function($scope){
    $scope.dataSource = [
        {name:'张三',age:12},
        {name:'李四',age:13},
        {name:'王五',age:14},
        {name:'赵六',age:15},
        {name:'扬起',age:16},
        {name:'张三',age:12},
        {name:'李四',age:13},
        {name:'王五',age:14},
        {name:'赵六',age:15},
        {name:'扬起',age:16},
        {name:'张三',age:12},
        {name:'李四',age:13},
        {name:'王五',age:14},
        {name:'赵六',age:15},
        {name:'扬起',age:16}
    ];
    //设置表头显示名称(name->姓名   age->年龄)
    $scope.columnDefs1 = [
        { field:'name', displayName:'姓名',enableCellEdit:true,cellClass:'name'},
        { field:'age', displayName:'年龄',enableCellEdit:true,maxWidth:4}
    ];
    $scope.gridOptions = {
        data:'dataSource',
        columnDefs:"columnDefs1",
        enableColumnResize:false,     //改变列的size
        enableCellSelection:true,     //设置单元格是否可被选中
        enableHighLighting:true,      //Enable or disable cell content selection
        enablePaging:true,            //是否允许分页
        groups:[],                    //分组
        headerRowHeight:32            //header row 的像素
    }
}]);