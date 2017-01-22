var querystring = require("querystring");

var url = "a=b&b=c&a=d";
console.info(querystring.parse(url));
console.info(querystring.parse('w=%D6%D0%CE%C4&foo=bar', null, null, { decodeURIComponent: "UTF-8" }));