var myApp = angular.module("myApp",[]);
myApp.controller("myController",["$scope",function($scope){
    $scope.eastValue = ["骑士","公牛","热火","老鹰","黄蜂","魔术","凯尔特人","活塞","步行者","76人","猛龙","奇才","尼克斯","篮网","雄鹿"];
    $scope.westValue = ["雷霆","勇士","快船","马刺","火箭","湖人","小牛","鹈鹕","开拓者","爵士","国王","森林狼","掘金","太阳","灰熊"];
    $scope.westTeam = "";
    $scope.eastTeam = "";
    $scope.showDiv = false;

    $scope.showCompareDiv = function(){
        if($scope.eastTeam && $scope.westTeam){
            $scope.showDiv = true;
        }else{
            alert("请选择对比球队");
        }
    };

    $scope.hiddenCompareDiv = function(){
      $scope.showDiv = false;
    };
    //PF Power Forward 大前锋 SF Small Forward 小前锋 SG Shooting Guard 得分后卫 PG Point Guard 组织后卫
    $scope.teamInformation = [
        {
            teamName:'骑士',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
        {
            teamName:'公牛',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
        {
            teamName:'马刺',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
        {
            teamName:'快船',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
        {
            teamName:'勇士',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
        {
            teamName:'热火',
            FirstCenter:'莫兹戈夫',
            FirstPF:'乐福',
            FirstSF:'詹姆斯',
            FirstSG:'欧文',
            FirstPG:'香波特',
            SecondCenter:'考恩',
            SecondPF:'TT',
            SecondSF:'杰弗森',
            SecondSG:'JR',
            SecondPG:'小莫',
            alternate:'德拉维多瓦,康宁汉姆,琼斯，哈里斯',
            desc:''
        },
    ];

    //$scope.myHtml = '<div><table class="table table-hover table-bordered"><tr><td>hello</td><td>world</td></tr></table></div>';
    $scope.counter = 0;
    $scope.change = function(){
        $scope.counter++;
    };
    $scope.buYiDing = false;
    $scope.sb = function(){
      $scope.buYiDing = true;
    };
    $scope.bs = function(){
        if($scope.buYiDing === false){
            return;
        }else{
          $scope.buYiDing = false;
        };
    };
    $scope.money = 100;
    $scope.student = {
        name:'郭靖',
        from:'射雕英雄传',
        character:'呆头呆脑,有原则',
        girlFriend:'黄蓉'
    };
    var student2 = angular.copy($scope.student);
    console.log("student2 = ");
    console.info(student2);
    student2.gender = "男";
    console.log("$scope.student = ");
    console.info($scope.student);
    console.log("student2 = ");
    console.info(student2);

    $scope.YJ = function(){
      alert("这是一个右击事件，爱信不信！");
        return false;
    };
}]);
myApp.directive("compareData",function(){
    return{
        restrict:'A',
        replace:true,
        scope:false,
        template:'<div>' +
                 '<table class="table table-striped">' +
                 '<tr><th>#</th><th>{{eastTeam}}</th><th>{{westTeam}}</th><th>描述</th></tr>' +
                 '<tr><td><strong>Center</strong></td><td>莫兹戈夫</td><td>博格特</td><td>莫兹戈夫年轻,脚步灵活,更胜一筹.骑士胜</td></tr>' +
                 '<tr><td><strong>PF</strong></td><td>乐福</td><td>格林</td><td>在这一点上,乐福和个人一样出色.平手</td></tr>' +
                 '<tr><td><strong>SF</strong></td><td>詹姆斯</td><td>巴恩斯</td><td>我相信懂球的人都会选择詹姆斯的.没办法,联盟第一人的光环不是吹出来的.实力碾压.骑士胜</td></tr>' +
                 '<tr><td><strong>SG</strong></td><td>欧文</td><td>汤普森</td><td>健康的欧文是可以竞争联盟第一人的.而汤普森的得分能力也让我们大开眼界.骑士险胜</td></tr>' +
                 '<tr><td><strong>PG</strong></td><td>香波特</td><td>库里</td><td>毋庸置疑,库里作为联盟炙手可热的超级明星,香波特虽然防守很好,但是库里变态准.勇士胜</td></tr>' +
                 '</table>' +
                 '</div>'
    };
});
myApp.directive("terrible",function(){
    return{
        restrict: 'A',
        replace:true,
        scope:false,
        template:'<div ng-show="buYiDing">RLGL!The most Amazing and the most Terrible!Two dogs opposite!</div>'
    }
});

