var http = require('http');
//相当于jquery的模块  安装命令 npm install cheerio
var cheerio = require('cheerio');
var url = 'http://www.imooc.com/learn/348';

function filterChapters(html){
    var $ = cheerio.load(html);
    var chapters = $('.chapter');

    var courseData = [];

    chapters.each(function(item){
        var chapter = $(this);
        console.info(item === $(this));
        var chapterTitle = chapter.find('strong').text();
        var videos = chapter.find('.video').children('li');

        var chapterData = {
            chapterTitle :  chapterTitle,
            videos : []
        };

        videos.each(function(item){
            var video = $(this);
            var videoId = video.attr('data-media-id');
            var videoTitle = video.find('.J-media-item').text();
            chapterData.videos.push({
                videoId : videoId,
                videoTitle : videoTitle
            });
        });

        courseData.push(chapterData);
    });

    return courseData;
}

function printCourseData(courseData){
    courseData.forEach(function(item){
        var chapterTitle = item.chapterTitle;
        console.info(chapterTitle+'\n');

        item.videos.forEach(function(item1){
            console.info('   ['+item1.videoId+']'+':'+item1.videoTitle+'\n');
        });
    });
}

http.get(url,function(response){
    var html = "";

    response.on('data',function(data){
        html += data;
    });

    response.on('end',function(){
        var courseData = filterChapters(html);

        printCourseData(courseData);
    });
}).on('error',function(){
    console.info("获取课程网站源代码失败");
});