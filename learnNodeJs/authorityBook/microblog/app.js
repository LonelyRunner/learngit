var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var index = require('./routes/index');
var users = require('./routes/users');
var hello = require('./routes/hello');
var helloWorld = require('./routes/helloWorld');
var util = require('util');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
/**
 * express.static() 托管静态文件  所有的路径都是相对于存放目录的
 * 因此 存放静态文件的目录名不会出现在 URL 中
 * ex: http://localhost:3000/images/0.jpg
 */

app.use(express.static(path.join(__dirname, 'public')));
/**
 * 所有通过 express.static 访问的文件都存放在一个“虚拟（virtual）”目录（即目录根本不存在）下面，
 * 可以通过为静态资源目录指定一个挂载路径的方式来实现
 */
app.use('/static',express.static(path.join(__dirname,'public')));

app.use('/', index);
app.use('/users', users);
app.use('/hello',hello);
//匹配多个参数 pathName 路径参数
app.use('/helloWorld/:username/:password',helloWorld);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
