angular.module('practiceApp', ['ngRoute', "hr", "ui","ngGrid",'ui.bootstrap' ]);

angular.module('practiceApp').config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/practice', {
            templateUrl: 'practice.html',
            controller: 'PracticeController'
        }).
        when('/business', {
            templateUrl: 'business.html',
            controller: 'BusinessController'
        }).otherwise({
            redirectTo: '/practice'
        });
    }]);

angular.module("practiceApp")
    .controller("AccordionsController", AccordionsController)
    .controller("ModalController", ModalController)
    .controller("BusinessController", BusinessController)
    .controller("PracticeController", PracticeController)
    .controller("Select2Controller", Select2Controller)
    .controller("GridController", GridController)
    .controller("TableController", TableController)
    .controller("ShortcutsController", ShortcutsController)
    .controller("EnterLoopController", EnterLoopController);

angular.module('practiceApp').value("modalOpt", {
    dialogClass: "modal",
    backdropFade: true,
    dialogFade: true,
    keyboard: false,
    backdrop: true,
    backdropClick: false
});
