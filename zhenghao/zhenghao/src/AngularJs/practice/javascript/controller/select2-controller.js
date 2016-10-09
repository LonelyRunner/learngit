Select2Controller.$inject = ["$scope"];
function Select2Controller($scope) {
    $scope.orderDrugInfo = {
        drugName: "金银花",
        frequency: "一天三次",
        administration: ""
    };
    $scope.drugDecoctionDictList=[
        {id:'01',codeName:"先煎",inputCode:"XJ"},
        {id:'02',codeName:"后下",inputCode:"HX"}
    ];
    $scope.frequencyDictList=[
        {id:'01',codeName:"一天一次",inputCode:"YTYC"},
        {id:'02',codeName:"一天两次",inputCode:"YTLC"},
        {id:'03',codeName:"一天三次",inputCode:"YTSC"},
        {id:'04',codeName:"一周一次",inputCode:"YZYC"}
    ];

    //格式化select2列表项的显示方式，可以替换css样式，html结构等
    var drugDecoctionFormatResult = function (item) {
        var markup = "<span class='select2-input'>" + item.codeName + "</span>";
        return markup;
    };
    //格式化选中项目的显示方式
    var drugDecoctionFormatSelection = function (item) {
        return item.codeName;
    };
    $scope.drugDecoctionOpts = {
        data: $scope.drugDecoctionDictList,
        dropdownAutoWidth: true,//显示项目的列表宽度是否自适应
        id: "codeName",//指定那个字段作为本记录的id，
        hrResultType: 'id',
        placeholder: "备注",
        allowClear: true,
        matcher: function (term, text, option) {
            var reg = new RegExp(term.toUpperCase());
            return reg.test(option.inputCode) || reg.test(option.codeName);
        },
        initSelection: function (element, callback) {
            var id = element.val();
            var exist=$scope.drugDecoctionDictList.some(function(e){
                return e.codeName===id;
            });
            if(!exist){
                $scope.drugDecoctionDictList.unshift({"codeId": "", "codeName": id, "inputCode": PinYin.CC2PY(id)})
            }
            $.each($scope.drugDecoctionDictList, function () {
                if (angular.equals(id, this.codeName)) {
                    callback(this);
                }
            });
        },
        createSearchChoice: function (term) {//创建新的选项配置项
            var isExit = $scope.drugDecoctionDictList.some(function (item) {
                return term === item.codeName;
            });
            if (!isExit) {
                return {"codeId": "", "codeName": term, "inputCode": PinYin.CC2PY(term)};
            }
        },
        formatResult: drugDecoctionFormatResult,//格式化显示列表样式函数
        formatSelection: drugDecoctionFormatSelection//格式化选中结果样式
    };
}


