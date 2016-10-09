var myApp = angular.module("myApp",[]);
//myApp.controller("SomeController",function($scope){
//
//});

/** Example1 */

    //myApp.controller("MainController",function($scope){
    //    $scope.myProperty='wow,this is cool';
    //});
    //myApp.directive('myDirective',function(){
    //    return {
    //        restrict: 'A',
    //        scope: {},
    //        /** 指令中的替代元素不会访问到外部作用域中的myProperty */
    //        template: '<div>Inside myDirective {{myProperty}}</div>'
    //    }
    //});

/** Example2 */
    //myApp.directive('myDirective', function() {
    //    return {
    //        restrict: 'A',
    //        template: 'Inside myDirective, isolate scope: {{ myProperty }}',
    //        scope: {}
    //    };
    //});
    //myApp.directive('myInheritScopeDirective', function() {
    //    return {
    //        restrict: 'A',
    //        template: 'Inside myDirective, isolate scope: {{ myProperty }}',
    //        scope: true
    //    };
    //});
/** Example3 */
    myApp.controller("studentController",function($scope){
        $scope.student = "123321";
    });
    myApp.directive("myDirective",function(){
        return {
            restrict: 'E',
            replace: true,
            scope: {
                student: '@student'
            },
            template: '<div>InnerScope: {{student}}</div>'
        }
    });
