var orderStatusEnum = {
    OPEN: "0",
    SUBMIT: "1",
    CANCEL: "4",
    RETURN:"7",
    STOP:"3",
    EXECUTE:"2"
};

//function closeAlert() {
//    var divTemplate = document.getElementById("debuginfo");
//    var divLock = document.getElementById("lock");
//    document.body.removeChild(divTemplate);
//    document.body.removeChild(divLock);
//}
//
//(function () {
//    var _createNode = function (elmName, elmId, className, innerHtml, innerText, parentNode) {
//        var nodeElem = document.createElement(elmName);
//        if (typeof elmId !== "undefined") {
//            nodeElem.id = elmId;
//        }
//        if (typeof className !== "undefined") {
//            nodeElem.className = className;
//        }
//        if (typeof innerHtml !== "undefined") {
//            nodeElem.innerHTML = innerHtml;
//        }
//        if (typeof innerText !== "undefined") {
//            nodeElem.innerText = innerText;
//        }
//        if (parentNode === document) {
//            document.body.appendChild(nodeElem);
//            return nodeElem;
//        }
//        parentNode.appendChild(nodeElem);
//        return nodeElem;
//    };
//    var message = "";
//    window.onerror = function (msg, url, line) {
//        var errorInfo;
//        if (msg.indexOf("ReferenceError") > -1) {
//            errorInfo = "访问不存在的变量或者对象";
//        } else if (msg.indexOf("TypeError") > -1) {
//            errorInfo = "类型转换发生错误";
//        } else if (msg.indexOf("RangeError") > -1) {
//            errorInfo = "边界超出了范围";
//        } else if (msg.indexOf("Error") > -1) {
//            errorInfo = "系统发生错误";
//        }
//        else {
//            errorInfo = "无法预知的错误，请联系管理员!";
//        }
//        var splits = msg.split("Uncaught Error:");
//        if (splits instanceof  Array) {
//            msg = splits[1];
//        }
//        var divTemplate = document.getElementById("debuginfo");
//        var divLock = document.getElementById("lock");
//        if (divLock == null) {
//            var divLock = _createNode("div", "lock", "alert-level", undefined, undefined, document);
//        }
//        if (divTemplate == null) {
//            var divTemplate = _createNode("div", "debuginfo", "alert-message js-error-message", undefined, undefined, document);
//            var tempStr = "" + errorInfo + "<button class=\"close\" onclick='closeAlert()'>×</button>";
//            var titelElm = _createNode("h5", undefined, undefined, tempStr, undefined, divTemplate);
//            var contentElm = _createNode("div", undefined, "error-content-div", undefined, undefined, divTemplate);
//            var dlElm = _createNode("dl", undefined, undefined, undefined, undefined, contentElm);
//            var dtElm = _createNode("dt", undefined, undefined, undefined, "错误信息:", dlElm);
//            var ddElm = _createNode("dd", undefined, undefined, undefined, "" + msg + "", dlElm);
//            var dtElm1 = _createNode("dt", undefined, undefined, undefined, "错误文件:", dlElm);
//            var ddElm1 = _createNode("dd", undefined, undefined, undefined, "" + url + "", dlElm);
//            var dtElm2 = _createNode("dt", undefined, undefined, undefined, "错误行号:", dlElm);
//            var ddElm2 = _createNode("dd", undefined, undefined, undefined, "" + line + "", dlElm);
//            var footerHtml = "<button class=\"btn btn-primary\" onclick='closeAlert()'>关闭</button>";
//            var footerElm = _createNode("div", undefined, "message-bottom", footerHtml, undefined, divTemplate);
//        }
//        return false;
//    };
//})();

/**
 * URl工具类
 */
var Path = function () {
    var reg = /^\//;
    return {
        getUri: function (url) {
            if (reg.test(url)) {
                return encodeURI(url);
            } else {
                var pathName = window.document.location.pathname;
                return encodeURI(pathName.substring(0, pathName.substr(1).indexOf('/') + 1) + "/" + url);
            }
        },
        getWebstartUri: function (url) {
            return "http://localhost:8089/" + url;
        },
        getOrigin: function () {
            return window.document.location.origin;
        },
        getFuncSrc: function () {
            var pathName = window.document.location.pathname;
            return  pathName.substring(pathName.substr(1).indexOf('/') + 2, pathName.length);
        },
        refresh: function () {
            window.document.location.reload();
        },
        getPrefixUrl: function () {

        }
    };
}();

/**
 * 组装查询Uri时使用的工具类，组装时会忽略掉没有值的字段；
 * 对于其他特殊过滤条件的情况，需要提供接口函数，有待增强。
 * 使用方式：
 * var url = QueryUriBuilder.queryParam($scope.patientId, "patientId")
 *  .queryParam(null, "name")
 *  .queryParam($scope.pinyin, "pinyin")
 *  .build();
 *  返回组装好的字符串，结构为——?patientId=value&pinyin=value
 * @type {QueryUriParamBuilder}
 */
var QueryUriParamBuilder = (function () {
    var _urlStr = "";
    var _count = 0;
    var _acceptFilter = function (value2Check) {
        return value2Check !== undefined && value2Check !== null && value2Check !== "";
    };
    var _clearAndReturnGeneratedUrl = function () {
        var _generatedUrl = _urlStr;
        _urlStr = "";
        _count = 0;
        return _generatedUrl;
    };
    return {
        queryParam: function (value2Check, field2Check) {
            if (_acceptFilter(value2Check)) {
                if (_count === 0) {
                    _urlStr += "?" + field2Check + "=" + value2Check;
                } else {
                    _urlStr += "&" + field2Check + "=" + value2Check;
                }
                _count++;
            }
            return this;
        },
        build: function () {
            return _clearAndReturnGeneratedUrl();
        }
    };
})();

/**
 * 数学工具类
 */
var HrMath = function () {
    return {
        //修复四则运算浮点数精度问题
        fixArithmetic: function (m, n, op) {
            var a = (m + "");
            var b = (n + "");
            var x = 1;
            var y = 1;
            var c = 1;
            if (a.indexOf(".") > 0) {
                x = Math.pow(10, a.length - a.indexOf(".") - 1);
            }
            if (b.indexOf(".") > 0) {
                y = Math.pow(10, b.length - b.indexOf(".") - 1);
            }
            switch (op) {
                case '+':
                    c = Math.max(x, y);
                    m = Math.round(m * c);
                    n = Math.round(n * c);
                    return eval("(" + m + op + n + ")/" + c);
                case '-':
                    c = Math.max(x, y);
                    m = Math.round(m * c);
                    n = Math.round(n * c);
                    n = -n;
                    op = "+";
                    return eval("(" + m + op + n + ")/" + c);
                case '*':
                    c = x * y;
                    m = Math.round(m * x);
                    n = Math.round(n * y);
                    return eval("(" + m + op + n + ")/" + c);
                case '/':
                    c = Math.max(x, y);
                    m = Math.round(m * c);
                    n = Math.round(n * c);
                    c = 1;
                    return eval("(" + m + op + n + ")/" + c);
            }
        }
    };
}();

/**
 * 时间工具类
 */
var HrDate = function () {
    return {
        Y_MM_DD: "y-mm-dd",
        YY_MM_DD: "yy-mm-dd",
        HH_MM_SS: "HH:mm:ss",
        YY_MM_DD_HH_MM_SS: "yy-mm-dd HH:mm:ss",

        formatDate: function (date, format) {
            if (null !== date && undefined !== date) {
                return $.datepicker.formatDate(format, date);
            }
            return null;
        },
        formatTime: function (time, format) {
            if (null !== time && undefined !== time) {
                return $.datepicker.formatTime(format, {
                    hour: time.getHours(),
                    minute: time.getMinutes(),
                    second: time.getSeconds(),
                    millisec: time.getMilliseconds(),
                    timezone: time.getTimezoneOffset()
                });
            }
            return null;
        },
        formatDateTime: function (dateTime, dateFormat, timeFormat) {
            if (null !== dateTime && undefined !== dateTime) {
                return this.formatDate(dateTime, dateFormat) + " " + this.formatTime(dateTime, timeFormat);
            }
            return null;
        },
        getAgeFromBirthday: function (birth) {
            if (birth) {
                if (birth instanceof Date) {
                    birth = this.formatDate(birth, this.YY_MM_DD);
                }
                var newDate = new Date();
                var currentYear = newDate.getFullYear();
                var currentMonth = newDate.getMonth() + 1;
                var currentDay = newDate.getDate();

                var birthYear = birth.split("-")[0];
                var birthMonth = birth.split("-")[1];
                var birthDay = birth.split("-")[2];

                var myYear = currentYear - parseInt(birthYear);
                var myMonth = currentMonth - parseInt(birthMonth);
                var myDay = currentDay - parseInt(birthDay);

                var s = "";
                if (myDay < 0) {
                    myDay = myDay + 30;
                    myMonth--;
                }
                if (myMonth < 0) {
                    myMonth = myMonth + 12;
                    myYear--;
                }
                if ((myYear <= 0)) {
                    if (myMonth == 0) {
                        s = s + myDay + "天";
                    }
                    else {
//                        s = s + myMonth + "月" + myDay + "天";
                        s = s + myMonth + "个月" + myDay + "天";
                    }
                }
                else {
                    s = myYear + "岁";
                    if (myYear < 6) {
                        s = s + myMonth + "月";
                    }
                }
                if (s == "0天") {
                    s = "1天";
                }
                return s;
            }
        },
        compare: function (date1, date2) {
            var year1 = date1.getFullYear();
            var month1 = date1.getMonth() + 1;
            var day1 = date1.getDate();
            var year2 = date2.getFullYear();
            var month2 = date2.getMonth() + 1;
            var day2 = date2.getDate();
            var d1 = year1 + "-" + month1 + "-" + day1;
            var d2 = year2 + "-" + month2 + "-" + day2;
            if (d1 > d2) {
                return 1;
            } else if (d1 < d2) {
                return -1;
            } else {
                return 0;
            }
        },
        plusOrMinus: function (date, interval, num) {
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var hour = date.getHours();
            var minute = date.getMinutes();
            var second = date.getSeconds();
            switch (interval) {
                case "YEAR":  year += num; break;
                case "MONTH":  month += num; break;
                case "DATE":  day += num; break;
                case "HOUR":  hour += num; break;
                case "MINUTE":  minute += num; break;
                case "SECOND":  second += num; break;
                default : ;
            }
            var dateStr = year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second;
            var resultDate = new Date(dateStr);
            return resultDate;
        },
        dateType: {
            "YEAR": "YEAR",
            "MONTH": "MONTH",
            "DATE": "DATE",
            "HOUR": "HOUR",
            "MINUTE": "MINUTE",
            "SECOND": "SECOND"
        }
    };
}();

/**
 * 字符串工具类
 */
var HrStr = function () {
    return {
        isNull: function isNull(value) {
            if (value === undefined || value === null || value === "") {
                return true;
            }
            if (value !== undefined || value !== null || value !== "") {
                return false;
            }
        },
        nullToSpace: function nullToSpace(value) {
            if (this.isNull(value)) {
                return "";
            }
            return value;
        }
    };
}();

/**
 * 快捷键通用配置，现在以编码形式写死，后续看是否有必要迁移到参数配置中
 */
var HrKeys = function () {
    var arrays = [
        {code: "save", value: "S"},
        {code: "fresh", value: "F"},
        {code: "close", value: "C"},
        {code: "query", value: "Q"},
        {code: "order", value: "O"},
        {code: "delete", value: "D"},
        {code: "new", value: "N"},
        {code: "refresh", value: "R"}
    ];
    return {
        getKeyboardByCode: function (code) {
            var value;
            arrays.forEach(function (obj) {
                if (typeof code === "string") {
                    if (obj instanceof Object) {
                        if (obj.code === code) {
                            value = obj.value;
                            return value;
                        }
                    }
                }
            });
            return value;
        }
    };
}();

/**
 * 无分类工具类集合
 */
var HrUtils = function () {
    var selfErrorCallback = function (data, status, errorCallback, hrDialog) {
        if (typeof errorCallback === "function") {
            errorCallback(data, status);
        } else {
            HrUtils.httpError(data, status, hrDialog);
        }
    };
    return {
        httpMethod: {
            GET: "get",
            POST: "post",
            PUT: "put",
            DELETE: "delete"
        },
        httpError: function (data, status, hrDialog) {
            if (status === 412) {
                var messages = "";
                var length = data.errorList.length;
                for (var i = 0; i < length; i++) {
                    messages = messages +
                        data.errorList[i].field + ":" + data.errorList[i].message + ";";
                }
                hrDialog.dialog(hrDialog.typeEnum.EXCEPTION,
                    {message: "[" + data.message + "]" + messages, detail: "[" + data.message + "]" + messages});
            } else if (status === 503 || status === 404) {
                hrDialog.dialog(hrDialog.typeEnum.WARN,
                    {message: data.message, detail: data.message});
            } else {
                hrDialog.dialog(hrDialog.typeEnum.EXCEPTION,
                    {message: "服务器异常", detail: data.message});
            }
        },
        httpRequest: function ($http, url, successCallback, errorCallback, hrDialog, method, param) {
            if (angular.equals(method, "post")) {
                $http.post(Path.getUri(url), param).success(
                    function (data, status) {
                        if (typeof successCallback === "function") {
                            successCallback(data, status);
                        }
                    }
                ).error(
                    function (data, status) {
                        selfErrorCallback(data, status, errorCallback, hrDialog);
                    }
                );
            } else if (angular.equals(method, "put")) {
                $http.put(Path.getUri(url), param).success(
                    function (data, status) {
                        if (typeof successCallback === "function") {
                            successCallback(data, status);
                        }
                    }
                ).error(
                    function (data, status) {
                        selfErrorCallback(data, status, errorCallback, hrDialog);
                    }
                );
            } else if (angular.equals(method, "delete")) {
                $http.delete(Path.getUri(url)).success(
                    function (data, status) {
                        if (typeof successCallback === "function") {
                            successCallback(data, status);
                        }
                    }
                ).error(
                    function (data, status) {
                        selfErrorCallback(data, status, errorCallback, hrDialog);
                    }
                );
            } else {
                $http.get(Path.getUri(url)).success(
                    function (data, status) {
                        if (typeof successCallback === "function") {
                            successCallback(data, status);
                        }
                    }
                ).error(
                    function (data, status) {
                        selfErrorCallback(data, status, errorCallback, hrDialog);
                    }
                );
            }
        },
        copyProperties: function (dest, orig) {
            for(var i in dest) {
                if (dest.hasOwnProperty(i)) {
                    dest[i] = orig[i];
                }
            }
        }
    };
}();

/**
 * excel导出、通用报表打印工具类集合
 */
var HrExportExcel = function () {
    return {
        load: function ($http, report_url, parameters, successCallback, errorCallback) {
            var baseUri = getTopLevelConfig("Report_Service_Url");
            var _jsonStringParameter = JSON.stringify(parameters);
            var _report_url = baseUri + "/api/jasper-prints" + report_url + "?parameter=" + _jsonStringParameter;
            window.location.href = _report_url;
        }
    }
}();

/**
 *通用报表打印
 * @param hospitalName 医院名称
 * @param titleName 报表名称
 * @param formMaker 制表单位
 * @param madeBy 制表人
 * @param madeDate 制表日期
 * @param pageHeaderList 查询条件  如：["第一个输入条件:2016-01-01-2016-04-01", "第二个条件：第二条件", ......]
 * @param fillParameterVoList 各列的属性样式 如： [{headerName : "ID", fieldName : "id", width : "50", textAlign : "", pattern : "0.00"}]
 * @param dataSource 数据源
 * @param zebraListIndicator 是否隔行换色  1：是  0：否  （默认1是）
 * @constructor
 */
var HrReportPrint = function (hospitalName, titleName, formMaker, madeBy, madeDate,
                              pageHeaderList, fillParameterVoList, dataSource, zebraListIndicator) {
    var printInfoObject = {
        type: "report",
        appletParameters: {
            report_url: "api/jasper-prints/fill/common-report-print",
            printer_name: ((HrStr.isNull(getTopLevelConfig("Report_Printer")) || getTopLevelConfig("Report_Printer") == 0) ? null : getTopLevelConfig("Report_Printer")),
            is_direct_print: true,
            is_display: true
        },
        reportParameter: {
            reportFileName: "reports/common-portrait-report-template.jrxml",
            parameters: {
                hospitalName: hospitalName,
                titleName: titleName,
                formMaker: formMaker,
                madeBy: madeBy,
                madeDate: madeDate,
                zebraListIndicator : zebraListIndicator,
                pageHeader: pageHeaderList,
                fillParameterVo: fillParameterVoList,
                dataSource: dataSource
            }
        }
    };
    console.log(printInfoObject);
    window.parent.top.postMessage(printInfoObject, "*");
};

/**
 * 数组工具类
 */
var HrArray = function () {
    return {
        pushAll: function (targetArray, sourceArray) {
            sourceArray.forEach(function (item) {
                targetArray.push(item);
            });
        },
        exist: function (item, array) {
            return $.inArray(item, array) === -1 ? false : true;
        },
        inArray: function (item, array) {
            return $.inArray(item, array);
        },
        remove: function (item, array) {
            var index = $.inArray(item, array);
            if (index != -1) {
                array.splice(index, 1);
            }
        }
    };
}();

/**
 * 获取主框架信息工具类
 */
window.baseUtils = {};
baseUtils.getQueryString = function (queryString, name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = queryString.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2])
    }
    return null;
};
baseUtils.getUserId = function () {
    return baseUtils.getQueryString(window.document.location.search, "userId");
};
baseUtils.getAppId = function () {
    return baseUtils.getQueryString(window.document.location.search, "appId");
};

/**
 * 登录信息工具类
 */
var userInfo = function () {
    return{
        getUserInfo: function () {
            return window.parent.StaffDictVO;
        },
        getUserId: function () {
            return window.parent.StaffDictVO.empId;
        },
        getUserNo: function () {
            return window.parent.StaffDictVO.empNo;
        },
        getUserName: function () {
            return window.parent.StaffDictVO.staffName;
        },
        getDoctorInfo: function () {
            return window.parent.StaffDictVO.doctorDictVO;
        }
    };
}();

function _arrayBufferToBase64(buffer) {
    var binary = '';
    var bytes = new Uint8Array(buffer);
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode(bytes[ i ]);
    }
    return window.btoa(binary);
};
var Strings = function () {
    return {
        isNullOrEmpty: function (value) {
            if(value === null || value === undefined || (typeof value === "string" && value.trim().length === 0)) {
                return true;
            } else {
                return false;
            }
        }
    }
}();

var sourceCode = {
    accordionHtml: "<div ng-controller=\"AccordionsController\" class=\"accordion-index\">\n    <accordion close-others=\"true\">\n        <accordion-group ng-repeat=\"accordion in accordions\">\n            <accordion-heading>\n                {{accordion.title}}\n            </accordion-heading>\n            {{accordion.content}}\n        </accordion-group>\n    </accordion>\n</div>",
    accordionController: "AccordionsController.$inject = [\"$scope\"];\nfunction AccordionsController($scope) {\n    $scope.accordions = [\n        {title: \"Jersey\", content: \"Oracle公司推出的restful框架。可以集成至tomcat、jetty使用，支持Servlet和Spring的整合，支持jsr311的1.1和1.0版本。\"},\n        {title: \"Guice\", content: \"Google开发的一个轻量级，基于Java5（主要运用泛型与注释特性）的依赖注入框架(IOC)。\"},\n        {title: \"Java\", content: \"是一种可以撰写跨平台应用软件的面向对象的程序设计语言。\"}\n    ];\n}\n\n\n",
    modalHtml: "<div ng-controller=\"ModalController\" class=\"modal-index\">\n    <div>\n        <button class=\"btn btn-primary\" ng-click=\"showLoginModal()\">显示登录模态框</button>\n    </div>\n    <div hr-draggable modal=\"adminLoginModal\" options=\"modalOpt\" close=\"closeLoginModal()\">\n        <div class=\"modal-header\">\n            <button id=\"recordCloseButton\" type=\"button\" class=\"close\" ng-click=\"closeLoginModal()\">&times;</button>\n            <h5>管理员登陆</h5>\n        </div>\n        <div class=\"modal-body\">\n            <input type=\"text\" name=\"admin\" ng-model=\"admin.username\" placeholder=\"用户名\" autofocus/><br/>\n            <input type=\"password\" name=\"password\" ng-model=\"admin.password\" placeholder=\"密码\" autofocus/>\n            <input type=\"checkbox\" name=\"checkbox\" ng-model=\"savePassword\"/>记住密码\n        </div>\n        <div class=\"modal-footer\">\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"登陆\" ng-click=\"adminLogin()\" autofocus/>\n            <input type=\"submit\" class=\"btn btn-default\" value=\"取消\" ng-click=\"closeLoginModal()\" autofocus/>\n        </div>\n    </div>\n</div>\n",
    modalController:"ModalController.$inject = [\"$scope\", \"$location\", \"modalOpt\",\"hrDialog\"];\nfunction ModalController($scope, $location, modalOpt,hrDialog) {\n\n    $scope.adminLogin = adminLogin;\n    $scope.closeLoginModal = closeLoginModal;\n    $scope.showLoginModal = showLoginModal;\n    \n    function closeLoginModal() {\n        $scope.adminLoginModal = false;\n    }\n    \n    function showLoginModal() {\n        $scope.adminLoginModal = true;\n    }\n    \n    function adminLogin() {\n        if ($scope.admin.username.trim() != \"\" && $scope.admin.password.trim() != \"\") {\n            //identify success\n            var data = {\n            username: $scope.admin.username,\n            password: $scope.admin.password,\n            state: 1\n        };\n        sessionStorage.loginUser = data.username;\n        sessionStorage.loginUserState = data.state;\n        if ($scope.savePassword) {\n            localStorage.username = data.username;\n            localStorage.password = data.password;\n        } else {\n            localStorage.clear()\n        }\n        //business Handler\n        $location.path(\'/business\');\n        \n        } else {\n            hrDialog.dialog(hrDialog.typeEnum.WARN, {title: \"警告！\", message: \"用户名或密码不能为空！\"})\n                .close(function () {\n                });\n        }\n    }\n    \n    (function(){\n        $scope.savePassword = localStorage.username ? true : false;\n        $scope.admin = {\n            username: $scope.savePassword ? localStorage.username : \"\",\n            password: $scope.savePassword ? localStorage.password : \"\"\n        };\n        $scope.adminLoginModal = false;\n        $scope.modalOpt = modalOpt;\n    })();\n}\n\n\n",
    uiSelect2Html: "<div ng-controller=\"Select2Controller\">\n    <div>\n        <span>{{orderDrugInfo.drugName}}</span>\n        <span>\n            <select id=\"frequency\" ng-model=\"orderDrugInfo.frequency\"  ui-select2=\"{allowClear:true}\" class=\"input-medium\">\n                <option value=\"\"></option>\n                <option value=\"{{ frequencyDict.codeName }}\" ng-repeat=\"frequencyDict in frequencyDictList\">{{ frequencyDict.codeName }}\n                </option>\n            </select>\n        </span>\n        <span><input ui-select2=\"drugDecoctionOpts\"  ng-model=\"orderDrugInfo.administration\"/></span>\n    </div>\n    <div>{{orderDrugInfo}}</div>\n</div>\n",
    uiSelect2Controller:"Select2Controller.$inject = [\"$scope\"];\nfunction Select2Controller($scope) {\n    $scope.orderDrugInfo = {\n        drugName: \"金银花\",\n        frequency: \"一天三次\",\n        administration: \"\"\n    };\n    $scope.drugDecoctionDictList=[\n        {id:\'01\',codeName:\"先煎\",inputCode:\"XJ\"},\n        {id:\'02\',codeName:\"后下\",inputCode:\"HX\"}\n    ];\n    $scope.frequencyDictList=[\n        {id:\'01\',codeName:\"一天一次\",inputCode:\"YTYC\"},\n        {id:\'02\',codeName:\"一天两次\",inputCode:\"YTLC\"},\n        {id:\'03\',codeName:\"一天三次\",inputCode:\"YTSC\"},\n        {id:\'04\',codeName:\"一周一次\",inputCode:\"YZYC\"}\n    ];\n    \n    //格式化select2列表项的显示方式，可以替换css样式，html结构等\n    var drugDecoctionFormatResult = function (item) {\n        var markup = \"<span class=\'select2-input\'>\" + item.codeName + \"</span>\";\n        return markup;\n    };\n    //格式化选中项目的显示方式\n    var drugDecoctionFormatSelection = function (item) {\n        return item.codeName;\n    };\n    $scope.drugDecoctionOpts = {\n        data: $scope.drugDecoctionDictList,\n        dropdownAutoWidth: true,//显示项目的列表宽度是否自适应\n        id: \"codeName\",//指定那个字段作为本记录的id，\n        hrResultType: \'id\',\n        placeholder: \"备注\",\n        allowClear: true,\n        matcher: function (term, text, option) {\n            var reg = new RegExp(term.toUpperCase());\n            return reg.test(option.inputCode) || reg.test(option.codeName);\n            },\n            initSelection: function (element, callback) {\n                var id = element.val();\n                var exist=$scope.drugDecoctionDictList.some(function(e){\n                return e.codeName===id;\n            });\n            if(!exist){\n                $scope.drugDecoctionDictList.unshift({\"codeId\": \"\", \"codeName\": id, \"inputCode\": PinYin.CC2PY(id)})\n            }\n            $.each($scope.drugDecoctionDictList, function () {\n                if (angular.equals(id, this.codeName)) {\n                    callback(this);\n                }\n            });\n        },\n        createSearchChoice: function (term) {//创建新的选项配置项\n            var isExit = $scope.drugDecoctionDictList.some(function (item) {\n                return term === item.codeName;\n            });\n            if (!isExit) {\n                return {\"codeId\": \"\", \"codeName\": term, \"inputCode\": PinYin.CC2PY(term)};\n            }\n        },\n        formatResult: drugDecoctionFormatResult,//格式化显示列表样式函数\n        formatSelection: drugDecoctionFormatSelection//格式化选中结果样式\n    };\n}\n\n\n",
    tableHtml: "<div ng-controller=\"TableController\" class=\"table-index\">\n    <div hr-table widths=\"orderWidth\" class=\"current-doctor-orders\">\n        <div class=\"hr-table-header-div\">\n            <div class=\"hr-div-th\">\n                <table class=\"table table-bordered \">\n                    <thead>\n                    <tr>\n                        <th class=\'first-td\' width=\"25%\">药品</th>\n                        <th class=\'second-td\' width=\"25%\">数量</th>\n                        <th class=\'third-td\' width=\"25%\">医师</th>\n                        <th class=\'fourth-td\'width=\"25%\">状态</th>\n                    </tr>\n                    </thead>\n                </table>\n            </div>\n            <span class=\"hr-span-th\"></span>\n        </div>\n        <div class=\"hr-table-content-div\">\n            <table class=\"table table-striped table-bordered\">\n                <tbody>\n                <tr ng-repeat=\"orderDetail in orderDetailList\" ng-click=\"selectOrderDetail($index)\"\n                    ng-class=\"{\'bg-selected-color\': selectedOrderDetail==orderDetail}\">\n                    <td width=\"{{orderWidth[0]}}\">\n                        {{orderDetail.drugName}}\n                    </td>\n                    <td width=\"{{orderWidth[1]}}\">\n                        <span ng-show=\"isSelectedOrderDetail(orderDetail)\">\n                            <input type=\"text\" ng-model=\"orderDetail.amount\"/>\n                        </span>\n                        <span ng-show=\"!isSelectedOrderDetail(orderDetail)\">\n                            {{orderDetail.amount}}\n                        </span>\n                    </td>\n                    <td width=\"{{orderWidth[2]}}\">\n                        {{orderDetail.doctor}}\n                    </td>\n                    <td width=\"{{orderWidth[3]}}\">\n                        {{orderDetail.status}}\n                    </td>\n                </tr>\n            </table>\n        </div>\n    </div>\n</div>\n",
    tableController:"TableController.$inject = [\"$scope\"];\nfunction TableController($scope) {\n    //表格table各列自适应宽度List\n    $scope.orderWidth=[];\n    $scope.selectedOrderDetail = null;\n    $scope.selectOrderDetail = function (index) {\n        $scope.selectedOrderDetail = $scope.orderDetailList[index];\n    };\n    $scope.isSelectedOrderDetail=function(orderDetail){\n        return angular.equals($scope.selectedOrderDetail, orderDetail);\n    };\n}\n\n\n",
    ngGridHtml: "<div ng-controller=\"GridController\">\n    <div class=\"gridStyle no-border-top-left-right\" ng-grid=\"ordersGrid\">\n    </div>\n</div>\n",
    ngGridController:"GridController.$inject = [\"$scope\",\"$timeout\"];\nfunction GridController($scope) {\n    \n    var amountEditableCellTemplate = \'<div ng-if=\"!isSelectedOrderDetail(row.entity)\" >\\n    <span>{{COL_FIELD}}</span>\\n</div>\\n\\n<div  ng-if=\"isSelectedOrderDetail(row.entity)\">\\n    <input type=\\\'text\\\' ng-model=\\\'row.entity.amount\\\'>\\n</div>\';\n    \n    $scope.selectedOrderDetails = [];\n    $scope.selectedOrderDetail=null;\n    \n    $scope.columnDefs = [\n        {\n        field: \'drugName\', displayName: \'药品\', width: \"25%\",enableCellEdit: false, cellClass: \"text-center\", cellTemplate: \'\' +\n        \'<div class=\"ngCellText\">{{row.getProperty(col.field)}}</div>\'\n        },\n        {\n        field: \'amount\',\n        displayName: \'数量\',\n        width: \"25%\",\n        cellClass: \"text-center\",\n        enableCellEdit: true,\n        editableCellTemplate: amountEditableCellTemplate\n        },\n        {\n        field: \'doctor\', displayName: \'医师\', width: \"25%\",enableCellEdit: false, cellClass: \"text-center\", cellTemplate: \'\' +\n        \'<div class=\"ngCellText\">{{row.getProperty(col.field)}}</div>\'\n        },\n        {\n        field: \'status\', displayName: \'状态\', width: \"25%\",enableCellEdit: false, cellClass: \"text-center\", cellTemplate: \'\' +\n        \'<div class=\"ngCellText\">{{row.getProperty(col.field)}}</div>\'\n        }\n    ];\n    var rowTemplate = \"<div ng-style=\\\"{ \\\'cursor\\\': row.cursor}\\\" ng-repeat=\\\"col in renderedColumns\\\" ng-click=\\\"selectOrder(row.entity)\\\" ng-dblclick=\\\"updateOrder()\\\"\\n    ng-class=\\\"col.colIndex()\\\" class=\\\"ngCell\\\">\\n    <div ng-cell></div>\\n</div>\";\n    $scope.ordersGrid = {\n        data: \'orderDetailList\',\n        columnDefs: \'columnDefs\',\n        rowTemplate: rowTemplate,\n        enableColumnResize: false,\n        multiSelect: false,\n        enableSorting: true,\n        enableCellEditOnFocus: true,//1、为了让“行编辑”生效，首先允许 “单元格编辑”(为了使ngGrid使用 \"cellEditTemplate.html\"模版)\n        enableRowEditOnSelected: false,//2、行编辑模式：允许 “行编辑”\n        selectedItems: $scope.selectedOrderDetails,\n        beforeSelectionChange: function (rowItem, event) {\n            if (event.type === \"keydown\" && event.keyCode === 13) {\n                return false;\n            }\n            return true;\n        },\n        afterSelectionChange:function (rowItem,event){\n            $scope.selectedOrderDetails.splice(0);\n            $scope.selectedOrderDetails.push(rowItem.entity);\n            $scope.selectedOrderDetail=$scope.selectedOrderDetails[0];\n        }\n    };\n    \n    \n    $scope.isSelectedOrderDetail=function(entity){\n        return angular.equals(entity,$scope.selectedOrderDetail);\n    };\n    \n    $scope.getSelectedRowNum = function () {\n        var index = -1;\n        for (var i = 0; i < $scope.orderDetailList.length; i++) {\n            if ($scope.orderDetailList[i].orderId === $scope.selectedOrderDetail.orderId) {\n                index = i;\n                break;\n            }\n        }\n        return index;\n    };\n    \n    \n    $scope.updateOrder = function () {\n    \n    };\n    \n    //$scope.ordersGrid.selectItem(rowNum, true); 选中某一行\n    //$scope.ordersGrid.ngGrid.$viewport.scrollTop(grid.rowMap[rowNum] * grid.config.rowHeight); 设置滚动条\n}\n\n\n",
    shortcutsHtml: "<div ng-controller=\"ShortcutsController\" class=\"table-index\">\n    <div>\n        <button class=\"btn btn-primary\" ng-click=\"saveDoctorOrder()\">保存(<span class=\"text-underline\">S</span>)</button>\n        <button class=\"btn btn-primary\" ng-click=\"deleteDoctorOrder()\">删除<hr-global-keys keyName=\"delete\" on=\"alt+d\" invoke=\"deleteDoctorOrder()\"/></button>\n    </div>\n</div>\n",
    shortcutsController:"ShortcutsController.$inject = [\"$scope\",\"hrDialog\",\"$timeout\",\"$q\"];\nfunction ShortcutsController($scope,hrDialog,$timeout,$q) {\n    $scope.$on(\"saveEvent\", function () {\n        if($scope.getTemplateShow(\"shortcuts\")) {\n            $timeout(function () {\n                $scope.saveDoctorOrder();\n            }, 100, true);\n        }\n    });\n    \n    $scope.saveDoctorOrder=function(){\n        hrDialog.dialog(hrDialog.typeEnum.SUCCESS, {title: \"成功！\", message: \"已保存！\"})\n            .close(function () {\n            \n            });\n    };\n    \n    $scope.deleteDoctorOrder=function(){\n        comfirmCheck().then(function(result){\n        if(result){\n            hrDialog.dialog(hrDialog.typeEnum.SUCCESS, {title: \"成功！\", message: \"已删除！\"})\n                .close(function () {\n                \n                });\n        }else{\n            hrDialog.dialog(hrDialog.typeEnum.EXCEPTION, {title: \"删除失败！\", message: \"用户取消！\",detail:\"这里是异常的详细信息！\"})\n                .close(function () {\n                \n                });\n            }\n        });\n        \n    };\n    \n    var comfirmCheck = function () {\n        var deferred = $q.defer();\n        hrDialog.dialog(hrDialog.typeEnum.CONFIRM, {\n            message: \"是否要删除？\", preventFocus: true, buttons: [\n                {result: \"ok\", label: \'是\', cssClass: \'btn-primary\'},\n                {result: \'no\', label: \'否\'}\n            ]\n        })\n            .close(function (result) {\n                if (result === \"ok\") {\n                    deferred.resolve(true);\n                } else {\n                    deferred.resolve(false);\n                }\n            });\n        return deferred.promise;\n    };\n}\n\n\n",
    enterloopHtml: "<div ng-controller=\"EnterLoopController\" class=\"enter-loop-index\">\n    <div class=\"span\">\n        <input type=\"text\" id=\"input1\" enter-loop=\"1\" enterindex=\"1\" select2-open=\"true\"\n               placeholder=\"请输入ID查询\" ng-model=\"search\" autoselect/>\n    </div>\n    <div class=\"span\">\n        <input type=\"text\" enter-loop=\"1\" enterindex=\"2\" class=\"input-time\" placeholder=\"执行时间\" ng-model=\"startDateTime\"\n               hr-date-time=\"dateOptions1\"/>\n\n    </div>\n    <div class=\"span\">\n        <input type=\"text\" id=\"input3\" enter-loop=\"1\" enterindex=\"3\" ng-model=\"input2\" enter-option=\"focusInput5(input2)\"/>\n    </div>\n    <div class=\"span\">\n        <select ui-select2 style=\"width: 200px\" id=\"input4\" enter-loop=\"1\" enterindex=\"4\">\n            <option value=\"{{ item.id }}\" ng-repeat=\"item in select2Options\">{{ item.text }}</option>\n        </select>\n    </div>\n    <div class=\"span\">\n        <select ui-select2 style=\"width: 200px\" id=\"input5\">\n            <option value=\"{{ item.id }}\" ng-repeat=\"item in select2Options\">{{ item.text }}</option>\n        </select>\n    </div>\n</div>",
    enterloopController:"EnterLoopController.$inject = [\"$scope\",\"$timeout\"];\nfunction EnterLoopController($scope,$timeout) {\n    $scope.dateOptions1 = {\n        pickerType: \"dateTimePicker\",\n        changeYear: true,\n        changeMonth: true,\n        hourGrid: 4,\n        minuteGrid: 10,\n        secondGrid: 10,\n        timeFormat: \'HH:mm:ss\',\n        dateFormat: \"yy-mm-dd\",\n        stepHour: 1,\n        stepMinute: 1,\n        stepSecond: 1,\n        minDateTime: new Date()\n    };\n    \n    $scope.select2Options = [\n        {id: \'1001\', text: \'JavaScript高级程序设计\'},\n        {id: \'1002\', text: \'大话设计模式\'},\n        {id: \'1003\', text: \'HTTP权威指南\'},\n        {id: \'1004\', text: \'Spring实战\'}\n    ];\n    \n    $scope.focusInput5=function(param){\n        if(!Strings.isNullOrEmpty(param)){\n            return \"input5\"\n        }\n        return true;\n    }\n}\n\n\n"
};
