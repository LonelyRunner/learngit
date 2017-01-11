var userInfoModule = angular.module('UserInfoApp', []);
userInfoModule.controller('UserInfoController', ['$scope',
    function($scope) {
        $scope.userInfo = {
            email: "253445528@qq.com",
            password: "253445528",
            autoLogin: true
        };
        $scope.getFormData = function() {
            console.log($scope.userInfo);
        };
        $scope.setFormData = function() {
            $scope.userInfo = {
                email: 'damoqiongqiu@126.com',
                password: 'damoqiongqiu',
                autoLogin: false
            }
        };
        $scope.resetForm = function() {
            $scope.userInfo = {
                email: "253445528@qq.com",
                password: "253445528",
                autoLogin: true
            };
        }
    }
]);
