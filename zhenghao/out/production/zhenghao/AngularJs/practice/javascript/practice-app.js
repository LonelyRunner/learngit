angular.module('practiceApp', ['ui.bootstrap', 'ngRoute', "hr", "ui","ngGrid"]);

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


/**
 * hrTable表格自动对齐
 */
angular.module('practiceApp').directive('hrTable', function ($timeout) {
    function tableAutoSize(scope, element, isWindows) {
        if (scope.widths) {
            if (scope.widths.length > 1) {
                if (isWindows) {
                    scope.widths.length = 0;
                } else {
                    return;
                }
            } else {
                scope.widths.length = 0;
            }
        }
        var tds = $(element[0]).find('tr:first-child td');
        var ths = $(element[0]).find('tr:first>th');
        var span = $(element[0]).find('.hr-span-th')[0];
        var divContent = $(element[0]).find('.hr-table-content-div')[0];
        span.width = divContent.offsetWidth - divContent.scrollWidth;
        span.height = ths[0].offsetHeight;
        //span.style.position = "absolute";
        var thStyle = window.getComputedStyle(ths[0], null);
        span.style.backgroundImage = thStyle.backgroundImage;
        span.style.width = span.width + "px";
        span.style.height = span.height - 1 + "px";
        if (tds.length > 0) {
            for (var i = 0; i < ths.length; i++) {
                var width = window.getComputedStyle(ths[i], null).width;
                if (scope.widths) {
                    scope.widths.push(width);
                } else {
                    tds[i].width = width;
                }
            }
        }
    }

    return {
        restrict: 'A',
        scope: {
            data: '=',
            show: '=',
            widths: '='
        },
        link: function (scope, element, attrs) {
            $(window).resize(function () {
                tableAutoSize(scope, element, true);
            });
            scope.$watch('data', function (newvalue) {
                if (newvalue) {
                    $timeout(function(){
                        tableAutoSize(scope, element, false)
                    },0);
                }
            }, true);

            scope.$watch('show', function (newvalue) {
                if (newvalue) {
                    $timeout(function(){
                        tableAutoSize(scope, element, false)
                    },0);
                }
            }, true);
        }
    }
});