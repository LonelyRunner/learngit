var fs = require('fs');

fs.readFile('0.jpg',function(err,origin_image_buffer){
    console.info(Buffer.isBuffer(origin_image_buffer));

    fs.writeFile('1.jpg',origin_image_buffer,function(err){
        if(err) console.info(err);
    });

    //var base64Image = new Buffer(origin_image_buffer).toString('base64');
    var base64Image = origin_image_buffer.toString('base64');

    console.info(base64Image);

    var decodeImage = new Buffer(base64Image,'base64');

    console.info(Buffer.compare(origin_image_buffer,decodeImage));

    fs.writeFile('2.jpg',decodeImage,function(err){
        if(err) console.info(err);
    });
});