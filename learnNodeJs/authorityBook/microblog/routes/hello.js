var express = require('express');
var router = express.Router();

router.get('/', function(req, res) {
    res.send('currentDate is :'+new Date());
});

module.exports = router;