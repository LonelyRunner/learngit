/**
 * Created by ZH on 2016/12/30.
 */
var fs = require('fs');
var data = fs.readFileSync('file1.txt','UTF-8');
console.info(data);
console.info('end...');