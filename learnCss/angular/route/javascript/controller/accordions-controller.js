AccordionsController.$inject = ["$scope"];
function AccordionsController($scope) {
    $scope.accordions = [
        {title: "Jersey", content: "Oracle公司推出的restful框架。可以集成至tomcat、jetty使用，支持Servlet和Spring的整合，支持jsr311的1.1和1.0版本。"},
        {title: "Guice", content: "Google开发的一个轻量级，基于Java5（主要运用泛型与注释特性）的依赖注入框架(IOC)。"},
        {title: "Java", content: "是一种可以撰写跨平台应用软件的面向对象的程序设计语言。"}
    ];
}


