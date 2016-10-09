var myApp = angular.module("myApp",["ui.bootstrap"]);
myApp.controller("myController",function($scope){
    $scope.addModal = false;
    $scope.modalOpt = {
        dialogClass:"modal",
        backdropFade:true,
        dialogFade:true,
        keyboard:true,
        backdrop:true,
        backdropClick:true
    };
});
