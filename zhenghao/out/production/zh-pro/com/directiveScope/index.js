var myApp = angular.module("myApp",[]);
myApp.directive("myDirective",function(){
    return {
        restrict: 'A',
        replace: true,
        template: '<div><label>My Url Field:</label><input type="text" ng-model="myUrl"><a href="{{myUrl}}">{{myLinkText}}</a><span>{{myAboutMe}}</span></div>',
        scope: {
            myUrl: '=someAttr',  /** 这里访问的是DOM元素中的 some-attr */
            myLinkText: '@',     /** 这里访问的是DOM元素中的 my-link-text*/
            myAboutMe: '&myAboutMe'
        }
    };
});
