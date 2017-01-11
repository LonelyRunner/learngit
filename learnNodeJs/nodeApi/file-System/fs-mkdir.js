var fs = require('fs');
var util = require('util');

var Cavaliers = [
    {
        'player-name' : 'LeBron James',
        'age':32,
        'mvp-times' : 4
    },
    {
        'player-name' : 'Kyrie Irving',
        'age':32,
        'mvp-times' : 4
    },
    {
        'player-name' : 'Kevin Love',
        'age':32,
        'mvp-times' : 4
    }
];

/**
 * 创建一个文件夹
 * fs.mkdir(path,options,callback);
 */
fs.mkdir('NBA',function(err){
    if(err){
        console.info(err);
    }else{
        fs.appendFile('./NBA/Cavaliers',util.inspect(Cavaliers),function(err){
            if(err){
                console.info('create Cavaliers file is error!');
            }
        });

        console.info('create a new file is successful');
    }
});

console.info('create a dir is successful');

/**
 * 同步方法 fs.mkdirSync(path,options);
 */

