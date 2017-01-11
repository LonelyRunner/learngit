var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  /**
   * render的功能是调用模板引擎 并将其产生的页面直接返回给客户端 接受两个参数
   * 1.模板的名称 即views目录下的模板文件名，不包含文件的扩展名
   * 2.传递给模板的数据  用于翻译模板
   */
  res.render('index', { title: 'Express' });
});

router.get('/zhenghao', function(req, res, next) {
  res.send('Hello World ! I want to cross the sea and sky!');
});

router.get('/list',function(req,res,next){
  res.render('list',{
      title:'List',
      items:[1991,'byvoid','express','node.js']
  });
});

router.get('/helper',function(req,res){
  res.render('viewHelper',{
      title:'Helpers'
  });
});

module.exports = router;
