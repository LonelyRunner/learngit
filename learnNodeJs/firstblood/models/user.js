var mongoose = require("mongoose");

//创建模型
var Schema = mongoose.Schema;

var userScheMa = new Schema({
    userid : String,
    password : String
});

//与users集合关联
exports.user = mongoose.model("users",userScheMa);