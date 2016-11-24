var stream = require('stream');
var util = require('util');

//自定义ReadStream
function ReadStream (){
  stream.Readable.call(this);
}

util.inherits(ReadStream,stream.Readable);

ReadStream.prototype._read = function(){
    this.push("I ");
    this.push("love ");
    this.push("Imooc!\n ");
    this.push(null);
};

//自定义WriteStream
function WriteStream(){
  stream.Writable.call(this);
}

util.inherits(WriteStream,stream.Writable);

WriteStream.prototype._write = function(chunk,encoding,cb){
    console.info(chunk);
    cb();
};

//自定义TransformStream
function TransformStream(){
    stream.Transform.call(this);
}

util.inherits(TransformStream,stream.Transform);

TransformStream.prototype._transform = function(chunk,encoding,cb){
    this.push(chunk);
    cb();
};

TransformStream.prototype._flush = function(cb){
    this.push("Hello! Yeah");
};

var rs = new ReadStream();
var ws = new WriteStream();
var ts = new TransformStream();

rs.pipe(ts).pipe(ws);