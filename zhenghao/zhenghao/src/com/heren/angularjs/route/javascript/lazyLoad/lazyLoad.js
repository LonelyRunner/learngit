var myApp = angular.module('myApp',[]);

myApp.config(['$ocLazyLoadProvider',function($ocLazyLoadProvider){
    $ocLazyLoadProvider.config({
        loadedModules:['monitorApp'],//主模块名
        jsLoader:requirejs, //使用requirejs去加载文件
        //主模块需要的资源   这里主要是子模块的声明文件
        files:['modules/summary','modules/appEngine','modules/alarm','modules/database'],
        debug:true
    });
}]);

/** 配置ui-route */

myApp.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouteProvider){
    var lazyDeferred;
    function resolveDep(param,tpl,module){
        var resolves = {
            loadMyCtr:['$ocLazyLoad','$templateCache','$q',function($ocLazyLoad,$templateCache,$q){
                lazyDeferred = $q.defer();
                return $ocLazyLoad.load({
                    name:module,
                    cache:false,
                    files:param.files
                })
                    .then(function(){
                        lazyDeferred.resolve($templateCache.get(tpl));
                    })
            }]
        };
        return resolves;
    }
    $urlRouteProvider.otherwise('/summary');

    /** 路由配置 */
    $stateProvider
        .state('module1',{
            url:'/module1',
            templateProvider:function(){return lazyDeferred.promise;},
            controller:'module1Controller',
            resolve:resolveDep({files:[
                'controllers/module1Ctrl',
                'services/module1Service',
                'directives/module1Directive'
            ]},'views/module1.html','app.module1')
        })
        .state('module2',{
            abstract:true,
            url:'/module2',
            templateUrl:'views/module2.html'
        })
        .state('module2.list',{
            url:'',
            templateProvider:function(){return lazyDeferred.promise;},
            controller:'module2Controller',
            resolve:resolveDep({files:[
                'controllers/module2ListCtrl',
                'services/module2Service'
            ]},'views/list.html','app.module1')
        })
        .state('module1.detail',{
            url:'/:id',
            templateProvider:function(){return lazyDeferred.promise;},
            controller:'detailController',
            resolve:resolveDep({files:[
                'controllers/detailCtrl',
                'services/detailService'
            ]},'views/detail.html','app.module2')
        })
}]);