PracticeController.$inject = ["$scope","$timeout"];
function PracticeController($scope,$timeout) {
    $scope.selectedTemplate = {
        type: null
    };
    $scope.showTemplateType = function (template) {
        $scope.selectedTemplate.type = template;
        if(template==="modal"){

        }else if(template==="uiSelect2"){
            $timeout(function(){
                $("#frequency").select2("open");
            },100)
        }else if(template==="table"){

        }else if(template==="ngGrid"){

        }else if(template==="shortcuts"){

        }else if(template==="enterloop"){
            $timeout(function(){
                $("#input1").focus();
            },100)
        }else if(template==="accordion"){

        }
    };
    $scope.getTemplateShow = function (template) {
        return template === $scope.selectedTemplate.type;
    };
    $scope.showTabNavClass=function(template){
        if(angular.equals(template,$scope.selectedTemplate.type)){
            return "active";
        }else{
            return "non-active";
        }
    };
    $scope.orderDetailList = [
        {orderId:"1600000001",drugName: "维C银翘片",amount:2, doctor: "王一", status: "开立"},
        {orderId:"1600000002",drugName: "青霉素",amount:3, doctor: "王一", status: "开立"},
        {orderId:"1600000003",drugName: "青霉素钠注射液",amount:4, doctor: "王一", status: "提交"},
        {orderId:"1600000004",drugName: "阿莫西林胶囊",amount:3, doctor: "张三", status: "提交"},
        {orderId:"1600000005",drugName: "清咽可卡因",amount:6, doctor: "张三", status: "提交"},
        {orderId:"1600000006",drugName: "青霉素颗粒",amount:3, doctor: "张三", status: "执行"},
        {orderId:"1600000007",drugName: "穿心莲片",amount:3, doctor: "李四", status: "执行"},
        {orderId:"1600000008",drugName: "维生素C片",amount:3, doctor: "李四", status: "执行"},
        {orderId:"1600000009",drugName: "葡萄糖注射液",amount:5, doctor: "李四", status: "执行"}
    ];

    //绑定全局键盘事件
    //ALT+S 保存83
    $(document).on("keydown", function (e) {
        if (e.altKey && e.keyCode === 83) {
            $scope.$broadcast('saveEvent', []);
        }
    });

    $scope.htmlCode="";
    $scope.javascriptCode="";

    $scope.$watch("selectedTemplate.type",function(newval,oldval){
        if(newval){
            $scope.getSourceCode();
        }
    });

    $scope.getSourceCode=function(){
        $scope.htmlCode = sourceCode[$scope.selectedTemplate.type+"Html"];
        $scope.javascriptCode = sourceCode[$scope.selectedTemplate.type+"Controller"];
    }
}


