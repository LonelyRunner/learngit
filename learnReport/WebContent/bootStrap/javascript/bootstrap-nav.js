$(document).ready(function(){
    $(".content-detail").css("display","none");
    $("#Home").css("display","block");
    $(".a-li").on("click",function(){
        $(".a-li").removeClass("active");
        $(this).addClass("active");
        $(".content-detail").css("display","none");
        var idSelector = "#"+$(this).html().split(">")[1].split("<")[0];
        $(idSelector).css("display","block")
    });

    var fontSize = 14;

    $("#larger").on("click",function(){
        fontSize += 2;
        if(fontSize<=50){
            $("#testAttr").css("font-size",fontSize+"px");
        }else{
            $("#larger").attr("disabled","disabled");
        }
        $("#smaller").removeAttr("disabled");
    });

    $("#smaller").on("click",function(){
        fontSize -= 2;
        if(fontSize>=14){
            $("#testAttr").css("font-size",fontSize+"px");
        }else{
            $("#smaller").attr("disabled","disabled");
        }
        $("#larger").removeAttr("disabled");
    });

    $(".color-select").on("click",function(){
        console.info($(this).css("background-color"));
        $("#testAttr").css("color",$(this).css("background-color"));
    });

    $("#testCss").on("click",function(){
        $("#SVN").toggleClass("blueBack");
    });
});
