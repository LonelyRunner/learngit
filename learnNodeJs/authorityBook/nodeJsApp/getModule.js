/**
 * Created by ZH on 2016/12/30.
 */
//对模块的访问
var module = require('./module');

module.setName('张三');
module.getName();

//对包的访问
var somePackage = require('./somePackage');

somePackage.Hello();