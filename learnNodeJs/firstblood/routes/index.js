var express = require('express');
var router = express.Router();
var mongoose = require("mongoose");
var user = require("../models/user").user;
mongoose.connect("mongodb://localhost/runoob");

/* GET home page. */
router.get('/', function(req, res) {
  res.render('index', { title: 'Index' });
});

/** login */
router.get('/login',function(req,res){
  res.render("login",{title:'login'});
});

/** logout */
router.get('/logout', function(req, res) {
  res.render('logout', { title: 'logout' });
});

router.get('/error',function(req,res){
  res.render("error",{title:'登录出错'});
});

/** homepage */
router.post('/homepage', function(req, res) {
    var query_doc = {userid: req.body.userid, password: req.body.password};
    (function(){
        user.count(query_doc, function(err, doc){
            if(doc == 1){
              console.log(query_doc.userid + ": login success in " + new Date());
              res.render('homepage', { title: 'homepage' });
            }else{
              console.log(query_doc.userid + ": login failed in " + new Date());
              res.redirect('/error');
            }
        });
    })(query_doc);
});

module.exports = router;
