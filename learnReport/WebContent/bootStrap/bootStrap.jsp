<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>bootStrap导航栏测试</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body{
            font-family: "Helvetica Neue",Helvetica,Arial,SansSerif;
            line-height: 140%;
            color: #333;
            font-size: 14px;
            background-color: #ffeffe;
        }
        .container{
            padding: 15px;
            margin: auto;
            border: 1px solid;
            background-color: #c4e3f3;
        }

        .blueBack{
            background-color: #5bc0de;
        }

        .content-detail{
            height: 500px;
        }

        .svnTest{
            border: 1px solid #FFD700;
            margin-left: 494px;
            margin-top: 234px;
        }
    </style>
    <script src="javascript/jquery.js"></script>
    <script src="javascript/bootstrap-nav.js"></script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1 class="text-center">Mr.ZhengHao Homepage</h1>
        </div>
        <div class="content">
            <div id="content-navigator">
                <ul class="nav nav-tabs">
                    <li class="a-li active"><a href="#">Home</a></li>
                    <li class="a-li"><a href="#">SVN</a></li>
                    <li class="a-li"><a href="#">iOS</a></li>
                    <li class="a-li"><a href="#">VB</a></li>
                    <li class="a-li"><a href="#">Java</a></li>
                    <li class="a-li"><a href="#">PHP</a></li>
                </ul>
            </div>
            <div id="content-c" style="height: 500px;border:1px solid">
                <div class="content-detail" id="Home">
                    <p id="testAttr" class="text-center text-primary" style="margin-top:80px">我是一只小小鸟</p>
                    <div style="border:1px solid;width:150px;margin-left:494px;margin-top:250px">
                        <button id="larger" class="btn-primary">放大字体</button>
                        <button id="smaller" class="btn-primary">缩小字体</button>
                    </div>

                    <div>
                        <table class="table-bordered" style="margin-left:518px;margin-top: 10px;">
                            <tr>
                                <td>
                                    <div class="color-select" style="width:20px;height: 20px;background-color: #cd0a0a;border-radius: 10px"></div>
                                </td>
                                <td>
                                    <div class="color-select" style="width:20px;height: 20px;background-color: #ec971f;border-radius: 10px"></div>
                                </td>
                                <td>
                                    <div class="color-select" style="width:20px;height: 20px;background-color: #ffff00;border-radius: 10px"></div>
                                </td>
                                <td>
                                    <div class="color-select" style="width:20px;height: 20px;background-color: #4cae4c;border-radius: 10px"></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="content-detail" id="SVN">
                    <input id="testCss" class="svnTest btn btn-danger" type="button" value="toggleClass测试">
                </div>
                <div class="content-detail" id="iOS">

                </div>
                <div class="content-detail" id="VB">

                </div>
                <div class="content-detail" id="Java">

                </div>
                <div class="content-detail" id="PHP">

                </div>
            </div>
        </div>
        <div class="footer" style="height: 120px;border:1px solid;">
            <p class="text-info text-center" style="margin-top:45px">版权 @ Mr.ZH.company location L.O.S</p>
        </div>
    </div>

</body>
</html>