var querystring = require("querystring");

var obj = {
    name:'张三',
    age:12,
    hobby : ['play','study']
};
//name=%E5%BC%A0%E4%B8%89&age=12&hobby=play&hobby=study
console.info(querystring.stringify(obj));
//name:%E5%BC%A0%E4%B8%89?age:12?hobby:play?hobby:study
console.info(querystring.stringify(obj,'?',":"));