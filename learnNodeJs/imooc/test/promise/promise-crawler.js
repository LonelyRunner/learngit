var http = require('http');
//相当于jquery的模块  安装命令 npm install cheerio
var cheerio = require('cheerio');
var Promise = require('bluebird');
var baseUrl = "http://www.imooc.com/learn/";
var vedioIds = [728,637,348,259,197,134,75];

function filterChapters(html){
    /** 返回的courseData的数据格式
        chapterData = {
            title : '',
            number : 0,
            chapters : []   //注释  chapters数组中存放 chapterData = {chapterTitle :  chapterTitle,videos : []}
        }
     * */
    var $ = cheerio.load(html);
    var title = $('.l').text();
    var number = $('.static-item .js-learn-num').text();
    var chapters = $('.chapter');

    var chapterData = {
        title : title,
        number : number,
        courseDatas : []
    };

    var courseData = [];

    chapters.each(function(item){
        var chapter = $(this);
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
    chapterData.courseDatas = courseData;

    return chapterData;
}

function printCourseData(allCourseData){
    allCourseData.forEach(function(chapterData){
        //console.info('课程名字:'+chapterData.title);
        console.info('学习人数:'+chapterData.number);
        //chapterData.courseDatas.forEach(function(item){
        //    var chapterTitle = item.chapterTitle;
        //    console.info(chapterTitle+'\n');
        //
        //    item.videos.forEach(function(item1){
        //        console.info('   ['+item1.videoId+']'+':'+item1.videoTitle+'\n');
        //    });
        //});
    });
}


function getPageAsync(url){
    return new Promise(function(resolve,reject){
        console.info("正在爬去 "+url);
        http.get(url,function(response){
            var html = "";

            response.on('data',function(data){
                html += data;
            });

            response.on('end',function(){
                resolve(html);
            });
        }).on('error',function(e){
            reject(e);
            console.info("获取课程网站源代码失败");
        });
    });
}

function getFetchHtmlArray(){
    var fetchHtmlArray = [];
    vedioIds.forEach(function(item){
        fetchHtmlArray.push(getPageAsync(baseUrl+item));
    });
    return fetchHtmlArray;
}

//同时解析多个url
Promise
    .all(getFetchHtmlArray())
    .then(function(pages){
        var allCourseData = [];

        pages.forEach(function(html){
            var courseData = filterChapters(html);

            allCourseData.push(courseData);
        });

        printCourseData(allCourseData);
    });

