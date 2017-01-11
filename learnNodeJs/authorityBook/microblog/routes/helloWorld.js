var express = require('express');
var router = express.Router();
var util = require('util');

router.get('/',function(req,res){
    //res.send("params are : username is "+req.params.username);
    res.send("params are : username is "+util.inspect(req));
});

module.exports = router;