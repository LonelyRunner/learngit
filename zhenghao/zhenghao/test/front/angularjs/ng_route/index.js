var ZHIndexApp = angular.module("ZHIndexApp",["ngRoute","ngGrid"]);

/** 数据的双向绑定 */
ZHIndexApp.controller("IntroduceSelfController",["$scope",function($scope){
    $scope.Mr_zh = {
        name : '郑豪',
        gender : '男',
        age : 23,
        graduate : '太原理工大学',
        major : '软件工程',
        experience1 : '无论我变得多么强大,你依然是我的弱点.' +
                      '这个世界上最好的爱就是让自己爱的人,找到她的爱.' +
                      '一个爱了多年的人,最后写的三个字不是"我爱你",而是"不值得"' +
                      '曾经,你的到来,让我从永无穷尽的劳作中抬起头,坐下来,静一静,望望瓦蓝的天,听听鸟儿的启迪,看看蜿蜒的曲径,目光空茫--' +
                      '曾经,你的到来,让我开始梳理被风吹乱的发辫,把衣服的褶皱儿抻平,在绚丽的春光中采摘芬芳',
        experience2 : '若非青春苦短谁会想来日方长.' +
                      '人总得为自己的错误付出代价,不是你说对不起,我就得说没关系.' +
                      '我们放下个性,放下尊严,放下固执,都因为放不下一个人.' +
                      '在生命中,在无聊的时光也都是限量版.' +
                      '曾经,你的到来,让我面壁思过,算一算这玄奥的机缘是不是走了千载才逢,算一算如今的应验是不是千百万年前的约定。那么,我浅浅的福分,是否匹配得上你如山的恩宠------'+
                      '曾经,你的到来,我要装聋作哑,环顾左右而言他,闭紧牙关,独自把两个人的秘密担承------'+
                      '曾经,你的到来,幻化我成为一棵老槐树,疲倦得恰好行至你的窗前脚步再也移不动,死心塌地停下来,招引两只小鸟筑巢------'+
                      '曾经,你的到来'
    };

}]);
ZHIndexApp.controller("ImagesShowController",["$scope",function($scope){
    $scope.a = "ImagesShowController";
}]);
ZHIndexApp.controller("WriteByHeartController",["$scope","$timeout",function($scope,$timeout){
    $scope.time = "";
    addTime();
    function addTime(){
        var nowTime = new Date();
        var month = nowTime.getMonth()+1;
        var date = nowTime.getDate();
        var str = '2016-'+month+'-'+date+' 17:30:00';
        var fiveDianBan = new Date(str);
        var cha = fiveDianBan - nowTime;
        var hours = isBiggerThanTen(parseInt(cha/3600000));
        var minutes = isBiggerThanTen(parseInt((cha-hours*3600000)/60000));
        var seconds = isBiggerThanTen(parseInt((cha-hours*3600000-minutes*60000)/1000));
        if(hours==="00" && minutes==="00" && seconds==="00"){
            $scope.time = "恭喜你,奋斗成功!"
        }else{
            $scope.time = hours+"小时"+minutes+"分"+seconds+"秒";
        }
        $timeout(addTime,1000);
    }

    function isBiggerThanTen(data){
        if(data*1<10){
            return "0"+data;
        }else{
            return data;
        }
    }
}]);

/** 带参数的路由 */
ZHIndexApp.controller("MusicGivenController",["$scope",function($scope){
    $scope.musicList = [
        {
            musicId : '01',
            musicName : '你到底爱着谁',
            musician : '刘嘉亮'
        },
        {
            musicId : '02',
            musicName : '约定',
            musician : '光良'
        },
        {
            musicId : '03',
            musicName : '口是心非',
            musician : '张雨生'
        },
        {
            musicId : '04',
            musicName : '当爱已成往事',
            musician : '张国荣'
        },
        {
            musicId : '05',
            musicName : '饿狼传说',
            musician : '张学友'
        },
        {
            musicId : '06',
            musicName : '我终于失去了你',
            musician : '李宗盛'
        },
        {
            musicId : '07',
            musicName : '关不上的窗',
            musician : '周传雄'
        }
    ];
}]);

/** ng-grid相关 */
ZHIndexApp.controller("MessageLeavenController",["$scope",function($scope){
    $scope.selectedItems = [];
    $scope.gridOpts = {
        i18n: 'zh-cn',
        data: 'dataList',
        enableColumnResize: true,
        enableCellEditOnFocus: false,
        enableRowEditOnSelected: true,
        enableCellEdit: false,
        enableRowSelection: true,
        columnDefs: 'colDefs',
        selectedItems : $scope.selectedItems
    };
    $scope.dataList = [
        {
            id : '推着三轮鄙视汽车',
            content : '这个主页做的太棒了'
        },
        {
            id : '我是谁的小苹果',
            content : '你是我的小呀小苹果'
        },
        {
            id : 'vip贵族',
            content : '爸爸再便宜,也是你买不起的奢侈品'
        },
        {
            id : '王炸',
            content : '你是天你是地,你是唯一的神话'
        }
    ];
    $scope.colDefs = [
        {field:'id',displayName:'留言Id'},
        {field:'content',displayName:'留言内容'}
    ];
    $scope.addMessage = function(){
        $scope.dataList.push(
            {
                id:'傻傻的莎莎',
                content : '我是一只小小小小鸟'
            }
        );
    };
    $scope.deleteMessage = function(){
        if($scope.selectedItems.length!=0){
            console.info($scope.selectedItems);
        }else{
            alert("请选中要删除的留言");
        }
    }
}]);

/** 过滤器 */
ZHIndexApp.controller("MusicGivenByIdController",["$scope","$routeParams",function($scope,$routeParams){
    $scope.lyrics1=[];
    $scope.lyrics2=[];
    $scope.lyrics3=[];
    if($routeParams.musicId){
        if($routeParams.musicId==='01'){
            var str = "你到底爱着谁," +
                            "演唱：刘嘉亮," +
                            "一个人喝醉,"+
                            "好想找个人来陪,"+
                            "我们之间有太多的误会,"+
                            "爱不能 再沉睡,"+
                            "是可悲 是摧毁,"+
                            "我不要再为谁掉眼泪,"+
                            "爱过才后悔,"+
                            "想要用酒来麻醉,"+
                            "我们之间有太多的误会,"+
                            "爱不能 再沉睡,"+
                            "是可悲 是摧毁,"+
                            "我不要再为谁而心碎,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "如果相爱是完美,"+
                            "就让我们用真心去面对,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "留下了太多伤悲,"+
                            "告诉我你到底爱着谁,"+
                            "爱过才后悔,"+
                            "想要用酒来麻醉,"+
                            "我们之间有太多的误会,"+
                            "爱不能 再沉睡,"+
                            "是可悲 是摧毁,"+
                            "我不要再为谁而心碎,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "如果相爱是完美,"+
                            "就让我们用真心去面对,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "留下了太多伤悲,"+
                            "告诉我你到底爱着谁,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "如果相爱是完美,"+
                            "就让我们用真心去面对,"+
                            "求求你给我个机会,"+
                            "不要再对爱说无所谓,"+
                            "留下了太多伤悲,"+
                            "告诉我你到底爱着谁,"+
                            "告诉我你到底爱着谁";
            var lyrics = str.split(",");
            for(var i=0;i<lyrics.length/3;i++){
                $scope.lyrics1.push(lyrics[i]);
            }
            for(var i=lyrics.length/3;i<2*lyrics.length/3;i++){
                $scope.lyrics2.push(lyrics[i]);
            }
            for(var i=2*lyrics.length/3;i<lyrics.length;i++){
                $scope.lyrics3.push(lyrics[i]);
            }
            console.info($scope.lyrics1);
            console.info($scope.lyrics2);
            console.info($scope.lyrics3);
        }else if($routeParams.musicId==='02'){
            $scope.lyrics = "约定-光良,"+
            "说好的三年不见面,"+
            "用我们的爱把时间留住,"+
            "你笑着说这是我们的考验," +
            "我们的约定,"+
            "就这样三年又过了,"+
            "我还是回到这个地方,"+
            "闭上眼等你的出现,"+
            "空气中吻你的脸,"+
            "我还记得我们的约定,"+
            "一辈子幸福的约定,"+
            "为你写的那首歌,"+
            "他也偷偷的掉泪了,"+
            "我还记得我们的约定,"+
            "我比以前还更爱你了,"+
            "连那风都笑我了,"+
            "我想他会告诉你的我更爱你了,"+
            "就这样三年又过了,"+
            "我还是回到这个地方,"+
            "闭上眼等你的出现,"+
            "空气中吻你的脸,"+
            "我还记得我们的约定,"+
            "一辈子幸福的约定,"+
            "为你写的那首歌,"+
            "他也偷偷的掉泪了,"+
            "我还记得我们的约定,"+
            "我比以前还更爱你了,"+
            "连那风都笑我了,"+
            "我想他会告诉你的,"+
            "你会记得我们的约定,"+
            "一辈子幸福的约定,"+
            "为你写的那首歌,"+
            "他也偷偷的掉泪了,"+
            "你会记得我们的约定,"+
            "我比以前还更爱你了,"+
            "迎着风我也笑了,"+
            "他一定会告诉你的我更爱你了";
        }else if($routeParams.musicId==='03'){

        }else if($routeParams.musicId==='04'){

        }else if($routeParams.musicId==='05'){

        }else if($routeParams.musicId==='06'){

        }else{

        }
    }
}]);

/**  路由配置   */
ZHIndexApp.config(["$routeProvider",function($routeProvider){
    $routeProvider.
    when('/introduceSelf', {
        controller: 'IntroduceSelfController',
        templateUrl: 'introduceSelf.html'
    }).
    when('/imagesShow', {
        controller: 'ImagesShowController',
        templateUrl: 'imagesShow.html'
    }).
    when('/writeByHeart', {
        controller: 'WriteByHeartController',
        templateUrl: 'writeByHeart.html'
    }).
    when('/musicGiven', {
        controller: 'MusicGivenController',
        templateUrl: 'musicGiven.html'
    }).
    when('/musicGiven/:musicId', {
            controller: 'MusicGivenByIdController',
            templateUrl: 'musicGivenById.html'
        }).
    when('/messageLeaven', {
        controller: 'MessageLeavenController',
        templateUrl: 'messageLeaven.html'
    }).
    otherwise({
        redirectTo: '/introduceSelf'
    });
}]);

