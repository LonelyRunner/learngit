var a = [
    {
        "detail":{
            "jobName":"患者执行记录",
            "jobGroupName":"HEREN-JOB-GROUP",
            "jobClass":"com.heren.his.domain.facade.schedule.JobForFacade",
            "description":"每日23.59.59生成患者医嘱执行记录",
            "jobDatas":[{"key":"facade","value":"performOrdersFacade"}]
        },
        "triggers":
            [
                {
                    "triggerFlag":1,
                    "triggerName":"2016011400000000000000000006",
                    "triggerGroupName":"HEREN-TRIGGER-GROUP",
                    "startTime":1452740726000,
                    "endTime":null,
                    "triggerState":"NORMAL",
                    "repeatCount":0,
                    "repeatInterval":0,
                    "cron":"59 59 23 * * ?"
                }
            ]
    }
];