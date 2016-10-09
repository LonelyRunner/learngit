var gridApp = angular.module("gridApp",['ngGrid']);
//自定义过滤器
gridApp.filter("addYear",function(){
    return function(input){
        var result = input+"岁";
        return result;
    }
});
gridApp.controller("gridController",["$scope",function($scope){
    $scope.selectedItem = {};
    $scope.dataList = [
        {username:'郑豪',gender:'男',age:23,graduate:'太原理工大学',from:'山西省晋中市祁县'},
        {username:'郭盼盼',gender:'男',age:23,graduate:'老汉推车大学',from:'山西省晋中市祁县'},
        {username:'杜益盛',gender:'男',age:23,graduate:'湖南某某技工学校',from:'山西省晋中市祁县'},
        {username:'李卫平',gender:'男',age:23,graduate:'英雄联盟大学',from:'山西省晋中市祁县'},
        {username:'武才人',gender:'女',age:24,graduate:'临汾师大',from:'山西省晋中市祁县'},
        {username:'张宝刚',gender:'男',age:24,graduate:'大同大学',from:'山西省晋中市祁县'},
        {username:'岳暄光',gender:'男',age:23,graduate:'太原电力大学',from:'山西省晋中市祁县'},
        {username:'韩国威',gender:'男',age:24,graduate:'河北电力大学',from:'山西省晋中市祁县'}
    ];
    
    var operateTemplate = '<input type="button" class="btn btn-primary" value="删除" ng-model="row.entity.operation" ng-click="deleteThisRow(row.entity)">';
    $scope.colDefs = [
        {field : 'username',displayName:'用户名'},
        {field : 'gender',displayName:'性别'},
        {field : 'age',displayName:'年龄',cellFilter:'addYear'},
        {field : 'graduate',displayName:'毕业于'},
        {field : 'from',displayName:'祖籍'},
        {displayName:'操作',cellTemplate:operateTemplate}
    ];
    $scope.gridOpts = {
        i18n: 'zh-cn',
        data: 'dataList',
        enableColumnResize: true,
        enableCellEditOnFocus: false,
        enableRowEditOnSelected: true,
        enableCellEdit: false,
        enableRowSelection: true,
        columnDefs: 'colDefs',
        selectedItem : 'selectedItem'
    };

    $scope.deleteThisRow = function(obj){
        var i = $scope.dataList.indexOf(obj);
        $scope.dataList.splice(i,1);
    }
}]);
