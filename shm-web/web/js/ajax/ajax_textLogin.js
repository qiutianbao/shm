$(document).ready(
    function() {

        // 直接把onclick事件写在了JS中

        $("#submit").click(
            function() {

                $.ajax({

                    // 后台处理程序

                    url : "/ajaxTest/ajax_text.action",

                    // 数据发送方式

                    type : "post",

                    // 接收数据格式

                    dataType : "text",

                    // 要传递的数据

                    data : "admin.username=" + $("#username").val() +

                        "&admin.password=" + $("#password").val(),

                    // 回传函数

                    timeout : 20000,// 设置请求超时时间（毫秒）。

                    error : function() {// 请求失败时调用函数。

                        $("#msg").html("请求失败!");

                    },

                    success : function(data) { // 请求成功后回调函数。

                        var dataObj = eval("(" + data + ")");// 转换为json对象

                        $("#msg").html(dataObj.message);

                        alert("用户名:" + dataObj.admin.username + ",密码:"
                            + dataObj.admin.password);

                        /*
                         * $("#msg").html(data.message);
                         *
                         * alert("用户名:" + dataObj.admin.username +
                         * ",密码:"
                         *  + dataObj.admin.password);
                         */

                    }

                });
                /*
                 *
                 * 如果接收数据dataType的值为“json”，就不用对返回值进行eval()处理了，因为它已经是json格式的了。那么最后几句代码应该改为：
                 *
                 * success:function(data){ //请求成功后回调函数。
                 *
                 * $("#msg").html(data.message);
                 *
                 * alert("用户名:"+dataObj.admin.username+",密码:"
                 *
                 * +dataObj.admin.password); }
                 *
                 */

            });

    });
