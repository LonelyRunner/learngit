/**
 * Created by ZH on 2015/12/10.
 */
var myApp = angular.module("myApp",[]);
myApp.directive("myDirective",function(){
    return {
        restrict:'A',
        replace:true,
        template:"<a href='{{myUrl}}'>{{myLinkText}}</a>"
    }
});
