ShortcutsController.$inject = ["$scope","hrDialog","$timeout","$q"];
function ShortcutsController($scope,hrDialog,$timeout,$q) {
    $scope.$on("saveEvent", function () {
        if($scope.getTemplateShow("shortcuts")) {
            $timeout(function () {
                $scope.saveDoctorOrder();
            }, 100, true);
        }
    });
    $scope.$on("deleteEvent", function () {
        if($scope.getTemplateShow("shortcuts")) {
            $timeout(function () {
                $scope.deleteDoctorOrder();
            }, 100, true);
        }
    });
    $scope.saveDoctorOrder=function(){
        hrDialog.dialog(hrDialog.typeEnum.SUCCESS, {title: "成功！", message: "已保存！"})
            .close(function () {

            });
    };

    $scope.deleteDoctorOrder=function(){
        comfirmCheck().then(function(result){
            if(result){
                hrDialog.dialog(hrDialog.typeEnum.SUCCESS, {title: "成功！", message: "已删除！"})
                    .close(function () {

                    });
            }else{
                hrDialog.dialog(hrDialog.typeEnum.EXCEPTION, {title: "删除失败！", message: "用户取消！",detail:"这里是异常的详细信息！"})
                    .close(function () {

                    });
            }
        });

    };

    var comfirmCheck = function () {
        var deferred = $q.defer();
        hrDialog.dialog(hrDialog.typeEnum.CONFIRM, {
                message: "是否要删除？", preventFocus: true, buttons: [
                    {result: "ok", label: '是', cssClass: 'btn-primary'},
                    {result: 'no', label: '否'}
                ]
            })
            .close(function (result) {
                if (result === "ok") {
                    deferred.resolve(true);
                } else {
                    deferred.resolve(false);
                }
            });
        return deferred.promise;
    };
}


