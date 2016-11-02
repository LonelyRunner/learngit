
var xmlHttp;

//键盘按下去后返回数据列表
function changeDataList(){
    var keyWord = document.getElementById("search-input").value;
    if(keyWord==""){
        clearContent();
        return;
    }
    xmlHttp = createXMLHttpRequest();
    var url = "search?keyword="+escape(keyWord);
    //第三个参数表示在xmlHttp 在send方法之后继续执行  而不会等待服务器的响应
    xmlHttp.open('GET',url,true);
    //callback回调函数
    xmlHttp.onreadystatechange = function(){
        //4表示完成
        if(xmlHttp.readyState == 4){
            //200表示服务器响应成功
            if(xmlHttp.status==200){
                var data = xmlHttp.responseText;
                // 将data转换为json
                // var json = JSON.parse(data);
                var arr = data.split(',');
                var resultArr = [];
                for(var i=0;i<arr.length-1;i++){
                    resultArr.push(arr[i]);
                }
                console.info(resultArr);
                // 将请求的数据展示到页面中
                showData(resultArr);
            }
        }
    };

    xmlHttp.send(null);
}

//创建xmlHttp
function createXMLHttpRequest(){
    var xmlHttp;
    if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }
    if(window.ActiveXObject){
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        if(!xmlHttp){
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
    return xmlHttp;
}

//设置关联数据的展示
function showData(content){
    clearContent();
    setLocation();
    var size = content.length;
    for(var i=0;i<size;i++){
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        var nextNode = content[i];
        td.setAttribute("bgColor","#FFFAFA");
        //鼠标移开
        td.onmouseout = function(){
            this.className = "mouseOut";
        };
        //鼠标移上去
        td.onmouseover = function(){
            this.className = "mouseOver";
        };
        //点击此td 将input框中的内容设置为此td中的内容
        td.onclick = function(){

        };

        var text = document.createTextNode(nextNode);
        td.appendChild(text);
        tr.appendChild(td);
        document.getElementById("data-show-table-tbody").appendChild(tr);
    }
}

//清空tbody中的内容
function clearContent(){
    var dom = document.getElementById("data-show-table-tbody");
    //从下往上清空
    for(var i=dom.childNodes.length-1;i>=0;i--){
        dom.removeChild(dom.childNodes[i]);
    }

    document.getElementById("dataShowArea").style.border = "none";
}

function setLocation(){
    var content = document.getElementById("search-input");
    var width = content.offsetWidth;
    var left = content['offsetLeft'];
    var top = content['offsetTop']+content.offsetHeight;

    var dataShowArea = document.getElementById("dataShowArea");
    dataShowArea.style.border = '1px #000 solid';
    dataShowArea.style.left = left+"px";
    dataShowArea.style.top = top+"px";
    dataShowArea.style.width = width+"px";
    
    document.getElementById("data-show-table").style.width=width;
}