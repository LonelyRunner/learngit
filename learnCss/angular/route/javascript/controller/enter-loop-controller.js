EnterLoopController.$inject = ["$scope","$timeout"];
function EnterLoopController($scope,$timeout) {
    $scope.dateOptions1 = {
        pickerType: "dateTimePicker",
        changeYear: true,
        changeMonth: true,
        hourGrid: 4,
        minuteGrid: 10,
        secondGrid: 10,
        timeFormat: 'HH:mm:ss',
        dateFormat: "yy-mm-dd",
        stepHour: 1,
        stepMinute: 1,
        stepSecond: 1,
        minDateTime: new Date()
    };

    $scope.select2Options = [
        {id: '1001', text: 'JavaScript高级程序设计'},
        {id: '1002', text: '大话设计模式'},
        {id: '1003', text: 'HTTP权威指南'},
        {id: '1004', text: 'Spring实战'}
    ];

    $scope.focusInput5=function(param){
        if(!Strings.isNullOrEmpty(param)){
            return "input5"
        }
        return true;
    }
}


