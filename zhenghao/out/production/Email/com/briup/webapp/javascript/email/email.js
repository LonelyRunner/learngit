var emailApp = angular.module('emailApp',['ui-router']);

emailApp.config(['$stateProvider','$urlProvider',function($stateProvider,$urlRouteProvider){
    $stateProvider
        .state('index',{
                url:'/index',
                templateUrl:'email/login.html',
                controller:'loginController'
            })
        .state('list',{
            url:'/list',
            templateUrl:'email/list.html',
            controller:'listController'
        })
        .state('send',{
                url:'/send',
                templateUrl:'email/send.html',
                controller:'sendController'
            })
        .state('receive',{
                url:'/receive',
                templateUrl:'email/receive.html',
                controller:'receiveController'
            });
    $urlRouteProvider.otherwise();
}]);

emailApp.controller('loginController',['$scope',function($scope){
    $scope.userName = "请输入用户名";
    $scope.password = "请输入密码";


}]);

/** 登录名 */
emailApp.controller('listController',['$scope',function($scope,$stateParams){
    $scope.userName = $stateParams.userName;
    if($scope.userName === "郑豪"){
        $scope.emailList = [
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            }
        ];
    }else if($scope.userName === "Mr.zheng"){
        $scope.emailList = [
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            }
        ];
    }else if($scope.userName === "小时代"){
        $scope.emailList = [
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            }
        ];
    }else{
        $scope.emailList = [
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            },
            {
                sender:'first',
                content:'one',
                rDate:'2015-01-01'
            }
        ];
    }
    $scope.deleteEmail = function(index){
        $scope.emailList.splice(index,1);
    };
}]);

emailApp.controller('sendController',['$scope',function($scope){

}]);

/** 接受者的标识,发送者的标识 */
emailApp.controller('receiveController',['$scope','$stateParams',function($scope,$stateParams){

}]);