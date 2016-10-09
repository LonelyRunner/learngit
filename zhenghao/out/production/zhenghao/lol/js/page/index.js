var LOLApp = angular.module("LOLApp",['ui.router']);

LOLApp.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("/login");
    $stateProvider
        .state('home',{
            url: '/login',
            templateUrl: 'login/login.html',
            controller: 'LoginController'
        })
        .state('index',{
            url: '/index',
            templateUrl: 'index/index.html',
            controller: 'homeController'
        })
        .state('hero_character',{
            url: '/hero_character?:hero_name',
            templateUrl: 'heros/hero-introduce.html',
            controller: 'heroController'
        })
});

LOLApp.controller("homeController",function($scope){
    $scope.heros = [
        {
            hero_name: '卡特琳娜',
            hero_Q: '弹射之刃',
            hero_W: '不祥之刃',
            hero_E: '瞬步',
            hero_R: '死亡莲华',
            hero_Passive: '贪婪',
            hero_img: '../images/1.jpg'
        },
        {
            hero_name: '牛头酋长',
            hero_Q: '大地粉碎',
            hero_W: '野蛮冲撞',
            hero_E: '胜利怒吼',
            hero_R: '坚定意志',
            hero_Passive: '践踏',
            hero_img: '../images/2.jpg'
        },
        {
            hero_name: '皮城执法官',
            hero_Q: '强能冲拳',
            hero_W: '爆弹重拳',
            hero_E: '透体之劲',
            hero_R: '天霸横空烈轰',
            hero_Passive: '爆裂护盾',
            hero_img: '../images/3.jpg'
        },
        {
            hero_name: '虚空行者',
            hero_Q: '虚无法球',
            hero_W: '虚空之刃',
            hero_E: '能量脉冲',
            hero_R: '虚空行走',
            hero_Passive: '虚空之石',
            hero_img: '../images/4.jpg'
        },
        {
            hero_name: '诺克萨斯之手',
            hero_Q: '大杀四方',
            hero_W: '致残打击',
            hero_E: '无情铁手',
            hero_R: '诺克萨斯断头台',
            hero_Passive: '出血',
            hero_img: '../images/5.jpg'
        },
        {
            hero_name: '蛮族之王',
            hero_Q: '嗜血杀戮',
            hero_W: '蔑视',
            hero_E: '旋风斩',
            hero_R: '无尽怒火',
            hero_Passive: '战斗狂怒',
            hero_img: '../images/6.jpg'
        },
        {
            hero_name: '黑暗之女',
            hero_Q: '碎裂之火',
            hero_W: '焚烧',
            hero_E: '熔岩护盾',
            hero_R: '提伯斯之怒',
            hero_Passive: '嗜火',
            hero_img: '../images/7.jpg'
        },
        {
            hero_name: '武器大师',
            hero_Q: '跳斩',
            hero_W: '蓄力一击',
            hero_E: '反击风暴',
            hero_R: '宗师之威',
            hero_Passive: '无情连打',
            hero_img: '../images/8.jpg'
        },
        {
            hero_name: '复仇焰魂',
            hero_Q: '火焰烙印',
            hero_W: '烈焰之柱',
            hero_E: '烈火燃烧',
            hero_R: '烈焰风暴',
            hero_Passive: '炽热之焰',
            hero_img: '../images/9.jpg'
        },
        {
            hero_name: '潮汐海灵',
            hero_Q: '淘气打击',
            hero_W: '海石三叉戟',
            hero_E: '古灵/精怪',
            hero_R: '巨鲨强袭',
            hero_Passive: '伶俐斗士',
            hero_img: '../images/10.jpg'
        },
        {
            hero_name: '维迦',
            hero_Q: '黑暗祭祀',
            hero_W: '黑暗物质',
            hero_E: '扭曲空间',
            hero_R: '能量爆裂',
            hero_Passive: '均衡',
            hero_img: '../images/11.jpg'
        },
        {
            hero_name: '远古巫灵',
            hero_Q: '奥能脉冲',
            hero_W: '毁灭之眼',
            hero_E: '冲击法球',
            hero_R: '奥术仪式',
            hero_Passive: '法力澎湃',
            hero_img: '../images/12.jpg'
        },
        {
            hero_name: '皇子',
            hero_Q: '巨龙撞击',
            hero_W: '黄金圣盾',
            hero_E: '德邦军旗',
            hero_R: '天崩地裂',
            hero_Passive: '战争律动',
            hero_img: '../images/13.jpg'
        },
        {
            hero_name: '嗜血猎手',
            hero_Q: '嗜血攻击',
            hero_W: '猎手怒吼',
            hero_E: '血迹追踪',
            hero_R: '无尽束缚',
            hero_Passive: '血之饥渴',
            hero_img: '../images/14.jpg'
        },
        {
            hero_name: '伊泽瑞尔',
            hero_Q: '秘术射击',
            hero_W: '精华跃动',
            hero_E: '奥术跃迁',
            hero_R: '精准弹幕',
            hero_Passive: '咒能高涨',
            hero_img: '../images/15.jpg'
        },
        {
            hero_name: '放逐之刃',
            hero_Q: '折翼之舞',
            hero_W: '震魂怒吼',
            hero_E: '勇往直前',
            hero_R: '放逐之锋',
            hero_Passive: '符文之刃',
            hero_img: '../images/16.jpg'
        },
        {
            hero_name: '海洋之灾',
            hero_Q: '枪火谈判',
            hero_W: '坏血病疗法',
            hero_E: '火药桶',
            hero_R: '加农炮幕',
            hero_Passive: '烈火审讯',
            hero_img: '../images/17.jpg'
        },
        {
            hero_name: '末日使者',
            hero_Q: '恐惧',
            hero_W: '生命吸取',
            hero_E: '黑暗之风',
            hero_R: '群鸦风暴',
            hero_Passive: '恐惧降临',
            hero_img: '../images/18.jpg'
        },
        {
            hero_name: '暴走萝莉',
            hero_Q: '枪炮交响曲',
            hero_W: '震荡电磁波',
            hero_E: '嚼火者手雷',
            hero_R: '超究极死神飞弹',
            hero_Passive: '罪恶快感',
            hero_img: '../images/19.jpg'
        },
        {
            hero_name: '光辉女郎',
            hero_Q: '光之束缚 ',
            hero_W: '曲光屏障 ',
            hero_E: '透光奇点 ',
            hero_R: '终极闪光 ',
            hero_Passive: '光芒四射',
            hero_img: '../images/20.jpg'
        },
        {
            hero_name: '无双剑姬',
            hero_Q: '破空斩',
            hero_W: '劳伦特心眼刀',
            hero_E: '夺命连刺',
            hero_R: '无双挑战',
            hero_Passive: '决斗之舞',
            hero_img: '../images/21.jpg'
        },
        {
            hero_name: '疾风剑豪',
            hero_Q: '斩钢闪',
            hero_W: '风之障壁',
            hero_E: '踏前斩',
            hero_R: '狂风绝息斩',
            hero_Passive: '浪客之道',
            hero_img: '../images/22.jpg'
        },
        {
            hero_name: '曙光女神',
            hero_Q: '破晓之盾',
            hero_W: '日蚀',
            hero_E: '天顶之刃',
            hero_R: '日炎耀斑',
            hero_Passive: '日光',
            hero_img: '../images/23.jpg'
        },
        {
            hero_name: '皎月女神',
            hero_Q: '新月打击',
            hero_W: '苍白之瀑',
            hero_E: '月之降临',
            hero_R: '月神冲刺',
            hero_Passive: '月银之刃',
            hero_img: '../images/24.jpg'
        },
        {
            hero_name: '寒冰射手',
            hero_Q: '射手的专注',
            hero_W: '万箭齐发',
            hero_E: '鹰击长空',
            hero_R: '魔法水晶箭',
            hero_Passive: '冰霜射击',
            hero_img: '../images/25.jpg'
        }
    ];
});
LOLApp.controller("heroController",function($scope,$stateParams){
    $scope.hero = isHero();
    function isHero(){
        var hero = {};
        var heros = [
            {
                hero_name: '卡特琳娜',
                hero_Q: '弹射之刃',
                hero_W: '不祥之刃',
                hero_E: '瞬步',
                hero_R: '死亡莲华',
                hero_Passive: '贪婪',
                hero_img: '../images/1.jpg'
            },
            {
                hero_name: '牛头酋长',
                hero_Q: '大地粉碎',
                hero_W: '野蛮冲撞',
                hero_E: '胜利怒吼',
                hero_R: '坚定意志',
                hero_Passive: '践踏',
                hero_img: '../images/2.jpg'
            },
            {
                hero_name: '皮城执法官',
                hero_Q: '强能冲拳',
                hero_W: '爆弹重拳',
                hero_E: '透体之劲',
                hero_R: '天霸横空烈轰',
                hero_Passive: '爆裂护盾',
                hero_img: '../images/3.jpg'
            },
            {
                hero_name: '虚空行者',
                hero_Q: '虚无法球',
                hero_W: '虚空之刃',
                hero_E: '能量脉冲',
                hero_R: '虚空行走',
                hero_Passive: '虚空之石',
                hero_img: '../images/4.jpg'
            },
            {
                hero_name: '诺克萨斯之手',
                hero_Q: '大杀四方',
                hero_W: '致残打击',
                hero_E: '无情铁手',
                hero_R: '诺克萨斯断头台',
                hero_Passive: '出血',
                hero_img: '../images/5.jpg'
            },
            {
                hero_name: '蛮族之王',
                hero_Q: '嗜血杀戮',
                hero_W: '蔑视',
                hero_E: '旋风斩',
                hero_R: '无尽怒火',
                hero_Passive: '战斗狂怒',
                hero_img: '../images/6.jpg'
            },
            {
                hero_name: '黑暗之女',
                hero_Q: '碎裂之火',
                hero_W: '焚烧',
                hero_E: '熔岩护盾',
                hero_R: '提伯斯之怒',
                hero_Passive: '嗜火',
                hero_img: '../images/7.jpg'
            },
            {
                hero_name: '武器大师',
                hero_Q: '跳斩',
                hero_W: '蓄力一击',
                hero_E: '反击风暴',
                hero_R: '宗师之威',
                hero_Passive: '无情连打',
                hero_img: '../images/8.jpg'
            },
            {
                hero_name: '复仇焰魂',
                hero_Q: '火焰烙印',
                hero_W: '烈焰之柱',
                hero_E: '烈火燃烧',
                hero_R: '烈焰风暴',
                hero_Passive: '炽热之焰',
                hero_img: '../images/9.jpg'
            },
            {
                hero_name: '潮汐海灵',
                hero_Q: '淘气打击',
                hero_W: '海石三叉戟',
                hero_E: '古灵/精怪',
                hero_R: '巨鲨强袭',
                hero_Passive: '伶俐斗士',
                hero_img: '../images/10.jpg'
            },
            {
                hero_name: '维迦',
                hero_Q: '黑暗祭祀',
                hero_W: '黑暗物质',
                hero_E: '扭曲空间',
                hero_R: '能量爆裂',
                hero_Passive: '均衡',
                hero_img: '../images/11.jpg'
            },
            {
                hero_name: '远古巫灵',
                hero_Q: '奥能脉冲',
                hero_W: '毁灭之眼',
                hero_E: '冲击法球',
                hero_R: '奥术仪式',
                hero_Passive: '法力澎湃',
                hero_img: '../images/12.jpg'
            },
            {
                hero_name: '皇子',
                hero_Q: '巨龙撞击',
                hero_W: '黄金圣盾',
                hero_E: '德邦军旗',
                hero_R: '天崩地裂',
                hero_Passive: '战争律动',
                hero_img: '../images/13.jpg'
            },
            {
                hero_name: '嗜血猎手',
                hero_Q: '嗜血攻击',
                hero_W: '猎手怒吼',
                hero_E: '血迹追踪',
                hero_R: '无尽束缚',
                hero_Passive: '血之饥渴',
                hero_img: '../images/14.jpg'
            },
            {
                hero_name: '伊泽瑞尔',
                hero_Q: '秘术射击',
                hero_W: '精华跃动',
                hero_E: '奥术跃迁',
                hero_R: '精准弹幕',
                hero_Passive: '咒能高涨',
                hero_img: '../images/15.jpg'
            },
            {
                hero_name: '放逐之刃',
                hero_Q: '折翼之舞',
                hero_W: '震魂怒吼',
                hero_E: '勇往直前',
                hero_R: '放逐之锋',
                hero_Passive: '符文之刃',
                hero_img: '../images/16.jpg'
            },
            {
                hero_name: '海洋之灾',
                hero_Q: '枪火谈判',
                hero_W: '坏血病疗法',
                hero_E: '火药桶',
                hero_R: '加农炮幕',
                hero_Passive: '烈火审讯',
                hero_img: '../images/17.jpg'
            },
            {
                hero_name: '末日使者',
                hero_Q: '恐惧',
                hero_W: '生命吸取',
                hero_E: '黑暗之风',
                hero_R: '群鸦风暴',
                hero_Passive: '恐惧降临',
                hero_img: '../images/18.jpg'
            },
            {
                hero_name: '暴走萝莉',
                hero_Q: '枪炮交响曲',
                hero_W: '震荡电磁波',
                hero_E: '嚼火者手雷',
                hero_R: '超究极死神飞弹',
                hero_Passive: '罪恶快感',
                hero_img: '../images/19.jpg'
            },
            {
                hero_name: '光辉女郎',
                hero_Q: '光之束缚 ',
                hero_W: '曲光屏障 ',
                hero_E: '透光奇点 ',
                hero_R: '终极闪光 ',
                hero_Passive: '光芒四射',
                hero_img: '../images/20.jpg'
            },
            {
                hero_name: '无双剑姬',
                hero_Q: '破空斩',
                hero_W: '劳伦特心眼刀',
                hero_E: '夺命连刺',
                hero_R: '无双挑战',
                hero_Passive: '决斗之舞',
                hero_img: '../images/21.jpg'
            },
            {
                hero_name: '疾风剑豪',
                hero_Q: '斩钢闪',
                hero_W: '风之障壁',
                hero_E: '踏前斩',
                hero_R: '狂风绝息斩',
                hero_Passive: '浪客之道',
                hero_img: '../images/22.jpg'
            },
            {
                hero_name: '曙光女神',
                hero_Q: '破晓之盾',
                hero_W: '日蚀',
                hero_E: '天顶之刃',
                hero_R: '日炎耀斑',
                hero_Passive: '日光',
                hero_img: '../images/23.jpg'
            },
            {
                hero_name: '皎月女神',
                hero_Q: '新月打击',
                hero_W: '苍白之瀑',
                hero_E: '月之降临',
                hero_R: '月神冲刺',
                hero_Passive: '月银之刃',
                hero_img: '../images/24.jpg'
            },
            {
                hero_name: '寒冰射手',
                hero_Q: '射手的专注',
                hero_W: '万箭齐发',
                hero_E: '鹰击长空',
                hero_R: '魔法水晶箭',
                hero_Passive: '冰霜射击',
                hero_img: '../images/25.jpg'
            }
        ];
        if($stateParams.hero_name){
            console.info($stateParams.hero_name);
            for(var i=0;i<heros.length;i++){
                if(heros[i].hero_name === $stateParams.hero_name){
                    hero = heros[i];
                }
            }
        }
        return hero;
    }
});
LOLApp.controller("LoginController",function($scope){
    $scope.username = "";
    $scope.password = "";
    $scope.isLogin = function(){
       return true;
    }

});
LOLApp.directive("login",function(){
    return {
        restrict: 'ECMA',
        replace: true,
        controller: function($scope){
            $scope.transportUrl = $scope.a;
            console.info("-----------------");
            console.info($scope.transportUrl);
            console.info("-----------------");
        },
        scope: {
            a:'=transportUrl'
        },
        template: '<a class="btn" href="{{transportUrl}}" ng-click="isLogin()">登录</a>'
    }
});