angular.module('EApp',[]);

angular.module("EApp").value("eChartOpts",{
    ringChart:{
        color:['#2cb998','#ff8f10','#7bb53c', '#2da5e3'],

        title:{
            text:'门诊人次',
            x:'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'horizontal',
            y:'bottom',
            data:[{name:'一般患者'},{name:'优先患者'}]
        },
        //color:['#ff8f10','#2cb998'],
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:'50%', name:'一般患者', itemStyle:{
                        normal:{color:'#2cb998'}
                    }},
                    {value:'50%', name:'优先患者', itemStyle:{
                        normal:{color:'#ff8f10'}
                    }}
                ]
            }
        ]
    },
    barAndLine:{
        color:['#2cb998','#ff8f10','#7bb53c', '#2da5e3'],
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['蒸发量','降水量','平均温度']
        },
        xAxis: [
            {
                type: 'category',
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                axisLabel : {
                    interval : 0,
                    rotate : 45
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '水量',
                //min: 0,
                //max: 250,
                //interval: 50,
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '温度',
                //min: 0,
                //max: 25,
                //interval: 5,
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            },
            {
                name:'降水量',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
            },
            {
                name:'平均温度',
                type:'line',
                yAxisIndex: 1,
                data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
            },
            {
                name:'大气温度',
                type:'line',
                yAxisIndex: 1,
                data:[1.0, 3.2, 4.3, 4.5, 6.3, 10.2, 20.3, 15.4, 23.0, 16.5, 12.0, 6.2]
            }
        ]
    },
    lineChart : {
        title: {
            text: '一天用电量分布',
            subtext: '纯属虚构'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend : {
            data : []
        },
        toolbox: {
            show: true,
            feature: {
                saveAsImage: {}
            }
        },
        xAxis:  {
            type: 'category',
            boundaryGap: false,
            data: ['00:00', '01:15', '02:30', '03:45', '05:00', '06:15', '07:30', '08:45', '10:00', '11:15', '12:30', '13:45', '15:00', '16:15', '17:30', '18:45', '20:00', '21:15', '22:30', '23:45'],
            axisLabel : {
                interval : 0,
                rotate : 45
            }
        },
        yAxis: {
            type: 'value',
            name:'例次',
            axisLabel: {
                formatter: '{value}'
            }
        },
        series: [
            {
                name:'用电量',
                type:'line',
                smooth: true,
                data: [300, 280, 250, 260, 270, 300, 550, 500, 400, 390, 380, 390, 400, 500, 600, 750, 800, 700, 600, 400]
            }
        ]
    }
});

angular.module("EApp").directive('eChart', function () {
    return {
        restrict: 'EA',
        template: '<div></div>',
        scope:{
            chartOptions:'=',
            dataChange:'='
        },
        replace: true,
        link: function (scope, elem, attrs) {
            var renderChart = function () {
                var opts = {};
                if (!angular.isUndefined(attrs.chartOptions)) {
                    opts = scope.chartOptions;
                    if (!angular.isObject(opts)) {
                        throw 'Invalid ui.chart options attribute';
                    }
                }

                console.info("opts----------");
                console.info(opts);
                var chartInstance = echarts.init(elem.get(0),'macarons');
                chartInstance.setOption(opts);
                chartInstance.resize();
            };


            scope.$watch("chartOptions",function(newValue,oldValue){
                renderChart();
            },true);

            $(window).resize(function () {
                var timeId = setTimeout(renderChart(),500);
                clearTimeout(timeId);
            });

        }
    };
});

angular.module("EApp").controller("eController",["$scope","eChartOpts",function($scope,eChartOpts){
    $scope.chartOption = eChartOpts.lineChart;
}]);