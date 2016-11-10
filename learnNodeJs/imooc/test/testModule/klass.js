var teacher = require('./teacher');
var student = require('./student');

function add(tName,sNames){
    teacher.add(tName);
    sNames.forEach(function(item){
        student.add(item)
    });
}

exports.add = add;