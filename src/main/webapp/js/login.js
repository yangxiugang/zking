$(function () {
    $("#4").hide();
    $("#5").hide();
    $("#6").hide();
})

function mylogin() {
    var name = $('#name').val();
    var pwd = $('#pwd').val();
    var type = $('input:radio:checked').val();
    if (name.length < 4) {
        $("#4").show();
        $("#5").hide();
        $("#6").hide();
        $.messager.show({
            title: '提示信息',
            msg: '请填选用户名',
            timeout: 1000,
            showType: 'slide'
        });
    } else {
        if (pwd.length < 4) {
            $("#4").hide();
            $("#5").show();
            $("#6").hide();
            $.messager.show({
                title: '提示信息',
                msg: '请输入密码',
                timeout: 1000,
                showType: 'slide'
            });
        }
    }
    if (name.length >= 4 && pwd.length >= 4) {
        $("#4").hide();
        $("#5").hide();
        $("#6").hide();
        $.ajax({
            type: "POST",
            url: "Login.action",
            dataType: "text",
            data: {
                user_name: name,
                user_pwd: pwd,
                user_type: type,
                t: new Date()
            },
            success: function (msg) {

                if (msg == "1") {
                    location.href = "../MyUsers/index.jsp";
                } else if (msg == "2") {
                    location.href = "../MyAdmin/console1.jsp";
                } else if (msg == "0") {
                    $.messager.show({
                        title: '提示信息',
                        msg: '用户不存在',
                        timeout: 1000,
                        showType: 'slide'
                    });
                } else {
                    location.href = "404.jsp";
                }
            }
        });
    }
}