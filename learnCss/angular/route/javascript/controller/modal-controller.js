ModalController.$inject = ["$scope", "$location", "modalOpt","hrDialog"];
function ModalController($scope, $location, modalOpt,hrDialog) {

    $scope.adminLogin = adminLogin;
    $scope.closeLoginModal = closeLoginModal;
    $scope.showLoginModal = showLoginModal;

    function closeLoginModal() {
        $scope.adminLoginModal = false;
    }

    function showLoginModal() {
        $scope.adminLoginModal = true;
    }

    function adminLogin() {
        if ($scope.admin.username.trim() != "" && $scope.admin.password.trim() != "") {
            //identify success
            var data = {
                username: $scope.admin.username,
                password: $scope.admin.password,
                state: 1
            };
            sessionStorage.loginUser = data.username;
            sessionStorage.loginUserState = data.state;
            if ($scope.savePassword) {
                localStorage.username = data.username;
                localStorage.password = data.password;
            } else {
                localStorage.clear()
            }
            //business Handler
            $location.path('/business');
        } else {
            hrDialog.dialog(hrDialog.typeEnum.WARN, {title: "警告！", message: "用户名或密码不能为空！"})
                .close(function () {
                });
        }
    }

    (function(){
        $scope.savePassword = localStorage.username ? true : false;
        $scope.admin = {
            username: $scope.savePassword ? localStorage.username : "",
            password: $scope.savePassword ? localStorage.password : ""
        };
        $scope.adminLoginModal = false;
        $scope.modalOpt = modalOpt;
    })();
}


