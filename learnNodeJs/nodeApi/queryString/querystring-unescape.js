var querystring = require("querystring");

var url = "a=b&b=c&c=d&d=a";

console.info(querystring.unescape(url));