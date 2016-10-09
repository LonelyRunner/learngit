var directiveApp = angular.module("directiveApp",[]);
directiveApp.controller("directiveController",["$scope",function($scope){
    $scope.books = '钢铁是怎样炼成的';
}]);

directiveApp.directive("myDirective",function(){
    return {
        restrict : 'ECMA',
        replace : true,
        scope : {
            color : '@color',         // 使用 @ 实现单向文本绑定
            link : '='   ,            // 使用 = 实现双向绑定
            book : '&books'//  使用 & 在父scope中执行函数
        },
        template : '<div style="background-color: {{color}}"><a href="{{link}}">我是一颗小小的石头 {{book()}}</a></div>',
        link : function(scope,elem,attr){
            elem.bind("click",function(){
                scope.$apply(function(){
                    scope.color = "white";
                });
            });

        }
    };
});