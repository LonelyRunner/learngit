<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>百度搜索框</title>
    <style type="text/css">
      #myDiv{
          position: absolute;
          left: 50%;
          top: 50%;
          margin-left: -200px;
          margin-top: -50px;
      }
      .mouseOut{
          background: #fffafa;
          color: #000000;
      }

      .mouseOver{
          background: #708090;
          color: #fffafa;
      }
    </style>
  </head>
  <body>
    <div id="myDiv">
      <input id="search-input" type="text" size="50" onkeyup="changeDataList()" onblur="clearContent()" onfocus="changeDataList()"/>
      <input id="search-btn" type="button" width="50px" value='百度一下'/>
      <div id="dataShowArea">
          <table id="data-show-table">
              <tbody id="data-show-table-tbody">

              </tbody>
          </table>
      </div>
    </div>
    <script src="search-index.js"></script>
  </body>
</html>
