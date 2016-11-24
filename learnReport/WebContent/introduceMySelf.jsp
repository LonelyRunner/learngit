<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>郑豪主页</title>
<link rel="stylesheet" href="common_css/index.css"></link>
</head>
<body>
		<div id="container">
        <div id="header"><h1>Mr.ZhengHao personal homepage</h1></div>

        <div id="menu">
            <table id="menu-table">
                <tr style="height: 60px;"><td id="table-menu">菜单</td></tr>
                <tr style="height: 60px;"><td class="td-btn"><a href="http://www.lx11451594.icoc.me/" class="a-btn">基本介绍</a></td></tr>
                <tr style="height: 60px;"><td class="td-btn"><a href="" class="a-btn">兴趣爱好</a></td></tr>
                <tr style="height: 60px;"><td class="td-btn"><a href="" class="a-btn">个人经历</a></td></tr>
                <tr style="height: 60px;"><td class="td-btn"><a href="" class="a-btn">音乐收藏</a></td></tr>
                <tr style="height: 60px;"><td class="td-btn"><a href="" class="a-btn">家乡介绍</a></td></tr>
            </table>
            <textarea id="motto" cols="20" rows="15" readonly style="background-color: darkseagreen">    优雅，是一种岁月，它是历经生命种种而呈现出的一种淡若不惊，褪去了少时的稚嫩，而呈现出的一种成熟的韵味. 一个优雅的人，一定有着独特的魅力，和饱满的，恬淡而丰盈的灵魂。生活多了一份阳光，少了一些阴霾，懂得了一步一个脚印的踏实和安稳。
            </textarea>
        </div>

        <div id="content">
            <div style="margin-left: 350px;margin-right: 350px;margin-top: 100px;">
                <canvas id="clock" height="400px" width="400px"></canvas>
            </div>
        </div>

        <div id="footer">
            版权 © Mr_ZH.com
        </div>
    </div>
    <script src="common_js/circle-clock.js"></script>
</body>
</html>