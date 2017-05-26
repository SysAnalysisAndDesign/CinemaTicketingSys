/**
 * Created by apple on 17/5/21.
 */
$().ready(function () {
    $("#regForm").validate({
        rules: {
            username: "required",
            password: {
                required: true,
                minlength: 6
            },
            passwordConfirm: {
                required: true,
                equalTo: "#password"
            }
        },

        messages: {
            username: "请输入用户名",
            password: {
                required: "请输入密码",
                minlength: "密码长度不能小于6个字母"
            },
            passwordConfirm: {
                required: "请输入密码",
                equalTo: "两次密码输入不一致"
            }
        }
    });
});